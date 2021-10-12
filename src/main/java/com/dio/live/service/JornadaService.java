package com.dio.live.service;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JornadaService {


    JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho){
       return jornadaRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> findAll() {
       return   jornadaRepository.findAll();
    }

    public JornadaTrabalho getById(Long id) throws NotFoundException {
        return verifyExists(id);
    }

    public JornadaTrabalho update(JornadaTrabalho jornadaTrabalho)throws NotFoundException {
        verifyExists(jornadaTrabalho.getId());
        return jornadaRepository.save(jornadaTrabalho);
    }

    public void delete(Long id) throws NotFoundException {
        verifyExists(id);
        jornadaRepository.deleteById(id);
    }



    public JornadaTrabalho verifyExists(Long id) throws NotFoundException {
        return jornadaRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }
}
