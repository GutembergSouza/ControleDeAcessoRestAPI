package com.dio.live.controller;

import com.dio.live.model.Usuario;
import com.dio.live.service.NotFoundException;
import com.dio.live.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuraio")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable("id") Long id)throws NotFoundException {
        return usuarioService.findById(id);
    }
    @GetMapping
    public List<Usuario> listAll(){
        return usuarioService.listAll();
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.create(usuario);
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario)throws NotFoundException{
       return usuarioService.update(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)throws NotFoundException{
        usuarioService.delete(id);
    }

}
