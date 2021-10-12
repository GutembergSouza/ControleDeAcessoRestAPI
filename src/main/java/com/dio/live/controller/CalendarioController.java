package com.dio.live.controller;

import com.dio.live.model.Calendario;
import com.dio.live.service.CalendarioService;
import com.dio.live.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {
    CalendarioService calendarioService;

    @Autowired
    public CalendarioController(CalendarioService calendarioService) {
        this.calendarioService = calendarioService;
    }

    @PostMapping
    public Calendario create(@RequestBody Calendario calendario){
        return calendarioService.create(calendario);
    }


    @GetMapping
    public List<Calendario> listAll(){
        return calendarioService.listAll();
    }

    @GetMapping("/{id}")
    public Calendario findById(@PathVariable("id") Long id) throws NotFoundException{
        return calendarioService.findById(id);
    }

    @PutMapping
    public Calendario update(@RequestBody Calendario calendario) throws NotFoundException {
        return calendarioService.update(calendario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) throws NotFoundException{
        calendarioService.delete(id);
    }




}
