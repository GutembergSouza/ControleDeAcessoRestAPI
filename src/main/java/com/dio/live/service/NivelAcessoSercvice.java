package com.dio.live.service;

import com.dio.live.model.NivelAcesso;
import com.dio.live.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelAcessoSercvice {

    NivelAcessoRepository nivelAcessoRepository;

    @Autowired
    public NivelAcessoSercvice(NivelAcessoRepository nivelAcessoRepository){
        this.nivelAcessoRepository = nivelAcessoRepository;
    }// injeçao de dependencia

    public NivelAcesso create(NivelAcesso nivelAcesso){
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public List<NivelAcesso> listAll(){
        return nivelAcessoRepository.findAll();
    }

    public NivelAcesso getById(Long id) throws NotFoundException {
        verifyExists(id);
        return nivelAcessoRepository.findById(id).get();
    }

    public void delete(Long id)throws NotFoundException {
         verifyExists(id);
         nivelAcessoRepository.deleteById(id);
    }

    public NivelAcesso update(NivelAcesso nivelAcesso) throws NotFoundException {
     verifyExists(nivelAcesso.getId());
     return nivelAcessoRepository.save(nivelAcesso);
    }

    public NivelAcesso verifyExists(Long id)throws NotFoundException {
       return nivelAcessoRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException(id));
    }


}
