package com.dio.live.controller;

import com.dio.live.model.Localidade;
import com.dio.live.service.LocalidadeService;
import com.dio.live.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {
    @Autowired
    LocalidadeService localidadeService;

    @GetMapping
    public List<Localidade> listAll(){
        return localidadeService.listAll();
    }

    @PostMapping
    public Localidade create(@RequestBody Localidade localidade){
        return localidadeService.create(localidade);
    }

    @PutMapping
    public Localidade update(@RequestBody Localidade localidade)throws NotFoundException {
        return localidadeService.update(localidade);
    }

    @GetMapping("/{id}")
    public Localidade findById(@PathVariable Long id) throws NotFoundException{
        return localidadeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)throws NotFoundException{
        localidadeService.delete(id);
    }
}
