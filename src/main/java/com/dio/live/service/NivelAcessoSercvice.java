package com.dio.live.service;

import com.dio.live.model.NivelAcesso;
import com.dio.live.repository.NivelAcessoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelAcessoSercvice {

    NivelAcessoRepository nivelAcessoRepository;

    @Autowired
    public NivelAcessoSercvice(NivelAcessoRepository nivelAcessoRepository){
        this.nivelAcessoRepository = nivelAcessoRepository;
    }// injeçao de dependencia

    public NivelAcesso save(NivelAcesso nivelAcesso){
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public List<NivelAcesso> listAll(){
        return nivelAcessoRepository.findAll();
    }

    public NivelAcesso getById(Long id) throws notFoundException{
        verifyExists(id);
        return nivelAcessoRepository.findById(id).get();
    }

    public void deleteById(Long id)throws notFoundException{
         verifyExists(id);
         nivelAcessoRepository.deleteById(id);
    }

    public NivelAcesso update(NivelAcesso nivelAcesso) throws notFoundException{
     verifyExists(nivelAcesso.getId());
     return nivelAcessoRepository.save(nivelAcesso);
    }

    public NivelAcesso verifyExists(Long id)throws notFoundException{
       return nivelAcessoRepository
                .findById(id)
                .orElseThrow(()-> new notFoundException(id));
    }


}
