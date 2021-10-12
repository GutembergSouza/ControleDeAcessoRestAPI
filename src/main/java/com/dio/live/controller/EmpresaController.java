package com.dio.live.controller;

import com.dio.live.model.Empresa;
import com.dio.live.service.EmpresaService;
import com.dio.live.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

    @GetMapping
    public List<Empresa> listAll(){
        return empresaService.listAll();
    }

    @PostMapping
    public Empresa create(@RequestBody Empresa empresa){
        return empresaService.create(empresa);
    }
    @GetMapping("/{id}")
    public Empresa findById(@PathVariable("id") Long id) throws NotFoundException {
        return empresaService.findById(id);
    }

    @PutMapping
    public Empresa update(@RequestBody Empresa empresa) throws NotFoundException{
        return empresaService.update(empresa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) throws NotFoundException{
        empresaService.delete(id);
    }


}
