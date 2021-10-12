package com.dio.live.controller;

import com.dio.live.model.Ocorrencia;
import com.dio.live.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.dio.live.service.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    OcorrenciaService ocorrenciaService;

    @Autowired
    public OcorrenciaController(OcorrenciaService ocorrenciaService) {
        this.ocorrenciaService = ocorrenciaService;
    }


    @PostMapping
    public Ocorrencia save(@RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.save(ocorrencia);
    }

    @GetMapping
    public List<Ocorrencia> listAll(){
        return ocorrenciaService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) throws NotFoundException {
       ocorrenciaService.deleteById(id);
    }
    @GetMapping("/{id}")
    public Ocorrencia getById(@PathVariable("id") Long id) throws NotFoundException {
       return ocorrenciaService.findByID(id);
    }

    @PutMapping
    public Ocorrencia update(@RequestBody Ocorrencia ocorrencia) throws NotFoundException {
       return ocorrenciaService.updateById(ocorrencia);
    }

}
