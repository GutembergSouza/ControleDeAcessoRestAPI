package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho save(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.create(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> listAll(){
        return jornadaService.findAll();
    }

    @GetMapping("/{id}")
    public JornadaTrabalho findById(@PathVariable("id") Long id) throws Exception{
       return jornadaService.getById(id);
    }

    @PutMapping
    public JornadaTrabalho update(@RequestBody JornadaTrabalho jornadaTrabalho)throws Exception{
        return jornadaService.update(jornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) throws Exception {
        jornadaService.delete(id);
    }

}
