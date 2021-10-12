package com.dio.live.controller;

import com.dio.live.model.TipoData;
import com.dio.live.service.NotFoundException;
import com.dio.live.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipodata")
public class TipoDataController {
    @Autowired
    TipoDataService tipoDataService;

    @GetMapping
    public List<TipoData> listAll(){
        return tipoDataService.listAll();
    }

    @PostMapping
    public TipoData create(@RequestBody TipoData tipoData){
        return tipoDataService.create(tipoData);
    }

    @PutMapping
    public TipoData update(@RequestBody TipoData tipoData) throws NotFoundException{
        return tipoDataService.update(tipoData);
    }
    @GetMapping("/{id}")
    public  TipoData findById(@PathVariable("id") Long id) throws NotFoundException {
        return tipoDataService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id)throws NotFoundException{
        tipoDataService.delete(id);
    }
}
