package com.dio.live.service;

import com.dio.live.model.Localidade;
import com.dio.live.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class LocalidadeService {
    LocalidadeRepository localidadeRepository;

    @Autowired
    public LocalidadeService(LocalidadeRepository localidadeRepository) {
        this.localidadeRepository = localidadeRepository;
    }

    public Localidade create(Localidade localidade){
        return localidadeRepository.save(localidade);
    }

    public List<Localidade> listAll(){
        return localidadeRepository.findAll();
    }

    public Localidade findById(Long id) throws NotFoundException{
        return verifyExists(id);
    }

    public Localidade update(Localidade localidade) throws NotFoundException {
        verifyExists(localidade.getId());
        return localidadeRepository.save(localidade);
    }

    public void delete(Long id)throws NotFoundException{
        verifyExists(id);
        localidadeRepository.deleteById(id);
    }

    public Localidade verifyExists(Long id) throws NotFoundException{
        return localidadeRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

}
