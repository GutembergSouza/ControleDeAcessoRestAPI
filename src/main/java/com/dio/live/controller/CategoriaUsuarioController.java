package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.repository.CategoriaUsuarioRepository;
import com.dio.live.service.CategoriaUsuarioService;
import com.dio.live.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriausuario")
public class CategoriaUsuarioController {
    @Autowired
    CategoriaUsuarioService service;

    @GetMapping
    public List<CategoriaUsuario> listAll(){
        return service.listAll();
    }

    @PostMapping
    public CategoriaUsuario create(@RequestBody CategoriaUsuario categoriaUsuario){
       return service.create(categoriaUsuario);
    }

    @GetMapping("/{id}")
    public CategoriaUsuario findById(@PathVariable("id") Long id) throws NotFoundException {
        return service.findById(id);
    }

    @PutMapping
    public CategoriaUsuario update(@RequestBody CategoriaUsuario categoriaUsuario) throws NotFoundException {
        return service.update(categoriaUsuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) throws NotFoundException {
        service.delete(id);
    }

}
