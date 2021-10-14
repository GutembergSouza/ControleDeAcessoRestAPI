package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.service.BancoHorasService;
import com.dio.live.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bancohoras")
public class BancoHorasController {
    BancoHorasService bancoHorasService;

    @Autowired
    public BancoHorasController(BancoHorasService bancoHorasService) {
        this.bancoHorasService = bancoHorasService;
    }

    @PostMapping
    public BancoHoras create(@RequestBody BancoHoras bancoHoras){
       return bancoHorasService.create(bancoHoras);
    }
    @GetMapping
    public List<BancoHoras> listAll(){
        return bancoHorasService.listAll();
    }
    @GetMapping("/{id}")
    public BancoHoras findById(@PathVariable("id") Long id) throws NotFoundException{
        return bancoHorasService.findById(id);
    }
    @PutMapping
    public BancoHoras update(@RequestBody BancoHoras bancoHoras) throws NotFoundException {
        return bancoHorasService.update(bancoHoras);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)  throws NotFoundException{
        bancoHorasService.delete(id);
    }



}
