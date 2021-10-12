package com.dio.live.service;

import com.dio.live.model.TipoData;
import com.dio.live.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TipoDataService {
    TipoDataRepository tipoDataRepository;

    @Autowired
    public TipoDataService(TipoDataRepository tipoDataRepository) {
        this.tipoDataRepository = tipoDataRepository;
    }

    public TipoData create(TipoData tipoData){
        return tipoDataRepository.save(tipoData);
    }

    public List<TipoData> listAll(){
        return tipoDataRepository.findAll();
    }

    public TipoData findById(Long id) throws NotFoundException{
        return verifyExist(id);
    }

    public TipoData update(TipoData tipoData)  throws NotFoundException{
       verifyExist(tipoData.getId());
       return tipoDataRepository.save(tipoData);
    }

    public void delete(Long id) throws NotFoundException{
        verifyExist(id);
        tipoDataRepository.deleteById(id);
    }

    public TipoData verifyExist(Long id) throws NotFoundException{
        return tipoDataRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }


}
