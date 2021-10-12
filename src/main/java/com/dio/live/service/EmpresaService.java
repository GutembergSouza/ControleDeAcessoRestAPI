package com.dio.live.service;

import com.dio.live.model.Empresa;
import com.dio.live.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class EmpresaService {

    EmpresaRepository empresaRepository;
    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }


    public Empresa create(Empresa empresa){
        return empresaRepository.save(empresa);
    }


    public List<Empresa> listAll(){
        return empresaRepository.findAll();
    }


    public Empresa findById(Long id) throws NotFoundException {
        return verifyExists(id);
    }


    public Empresa update(Empresa empresa)throws NotFoundException {
        verifyExists(empresa.getId());
        return empresaRepository.save(empresa);
    }


    public void delete(Long id) throws NotFoundException{
        verifyExists(id);
        empresaRepository.deleteById(id);
    }


    private Empresa verifyExists(Long id)throws NotFoundException{
        return empresaRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }
}
