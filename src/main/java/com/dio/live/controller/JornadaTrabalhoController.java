package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return jornadaService.save(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> listAll(){
        return jornadaService.findAll();
    }

    @GetMapping("/{id}")
    public JornadaTrabalho getById(@PathVariable("id") Long id) throws Exception{
       return jornadaService.getById(id);
    }

    @PutMapping
    public JornadaTrabalho update(@RequestBody JornadaTrabalho jornadaTrabalho)throws Exception{
        return jornadaService.update(jornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable("id") Long id) throws Exception {
        jornadaService.delete(id);
    }

}
