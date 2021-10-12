package com.dio.live.service;

import com.dio.live.model.Calendario;
import com.dio.live.repository.CalendarioRapository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarioService {
    CalendarioRapository calendarioRepository;

    @Autowired
    public CalendarioService(CalendarioRapository calendarioRapository) {
        this.calendarioRepository = calendarioRapository;
    }

    public Calendario create(Calendario calendario){
        return calendarioRepository.save(calendario);
    }

    public List<Calendario> listAll(){
        return calendarioRepository.findAll();
    }

    public Calendario findById(Long id) throws NotFoundException {
        verifyExists(id);
        return calendarioRepository.findById(id).get();
    }

    public Calendario update(Calendario calendario) throws NotFoundException{
        verifyExists(calendario.getId());
        return calendarioRepository.save(calendario);
    }

    public void delete(Long id) throws NotFoundException{
        verifyExists(id);
        calendarioRepository.deleteById(id);
    }

    private Calendario verifyExists(Long id) throws NotFoundException{
        return calendarioRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }


}
