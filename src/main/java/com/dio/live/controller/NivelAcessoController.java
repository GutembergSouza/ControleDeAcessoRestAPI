package com.dio.live.controller;

import com.dio.live.model.NivelAcesso;
import com.dio.live.service.NivelAcessoSercvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nivelacesso")
public class NivelAcessoController {

    @Autowired
    NivelAcessoSercvice nivelAcessoSercvice;

    @PostMapping
    public NivelAcesso createNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoSercvice.save(nivelAcesso);
    }

    @GetMapping
    public List<NivelAcesso> listAll(){
        return nivelAcessoSercvice.listAll();
    }

    @GetMapping("/{id}")
    public NivelAcesso getById(@PathVariable ("id") Long id) throws Exception{
        return nivelAcessoSercvice.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletByID(@PathVariable("id")Long id)throws Exception {
        nivelAcessoSercvice.deleteById(id);
    }

    @PutMapping
    public NivelAcesso update(@RequestBody NivelAcesso nivelAcesso) throws Exception{
        return nivelAcessoSercvice.update(nivelAcesso);
    }

}
