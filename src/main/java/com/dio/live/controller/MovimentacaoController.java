package com.dio.live.controller;

import com.dio.live.model.Movimentacao;
import com.dio.live.service.MovimentacaoService;
import com.dio.live.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao create(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.create(movimentacao);
    }

    @GetMapping
    public List<Movimentacao> listAll(){
        return movimentacaoService.listAll();
    }

    @GetMapping("/{id}")
    public Movimentacao findById(@PathVariable("id") Long id) throws NotFoundException {
        return movimentacaoService.findById(id);
    }

    @PutMapping
    public Movimentacao update(@RequestBody Movimentacao movimentacao)throws NotFoundException{
        return movimentacaoService.update(movimentacao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws NotFoundException{
        movimentacaoService.delete(id);
    }

}
