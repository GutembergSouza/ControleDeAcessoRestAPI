package com.dio.live.service;

import com.dio.live.model.BancoHoras;
import com.dio.live.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BancoHorasService {
    BancoHorasRepository bancoHorasRepository;

    @Autowired
    public BancoHorasService(BancoHorasRepository bancoHorasRepository) {
        this.bancoHorasRepository = bancoHorasRepository;
    }

    public BancoHoras create(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public List<BancoHoras> listAll(){
        return bancoHorasRepository.findAll();
    }

    public BancoHoras findById(Long id)throws NotFoundException{
        verifyExists(id);
        return bancoHorasRepository.findById(id).get();
    }

    public BancoHoras update(BancoHoras bancoHoras)throws NotFoundException{
      return bancoHorasRepository.save(bancoHoras);
    }

    public void delete(Long id) throws NotFoundException{
        verifyExists(id);
        bancoHorasRepository.deleteById(id);
    }

    public BancoHoras verifyExists(Long id) throws NotFoundException{
        return  bancoHorasRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }
}
