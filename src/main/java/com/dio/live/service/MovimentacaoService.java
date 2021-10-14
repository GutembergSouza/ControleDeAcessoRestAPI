package com.dio.live.service;

import com.dio.live.model.Movimentacao;
import com.dio.live.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {

    MovimentacaoRepository movimentacaoRepository;


      @Autowired
    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }


    public Movimentacao create(Movimentacao movimentacao){
        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> listAll(){
        return movimentacaoRepository.findAll();
    }

    public Movimentacao findById(Long id)  throws NotFoundException{
        return verifyExists(id);
    }

    public Movimentacao update(Movimentacao movimentacao) throws NotFoundException{
          movimentacaoRepository.findById(movimentacao.getMovimentacaoId().getIdMovimento()).orElseThrow(()->new NotFoundException(movimentacao.getMovimentacaoId()));
            return movimentacaoRepository.save(movimentacao);
      }

    public void delete(Long movimentacaoId)throws NotFoundException{
        Movimentacao movimentacaoPraDeletar= findById(movimentacaoId);
              movimentacaoRepository.delete(movimentacaoPraDeletar);
    }

    public Movimentacao verifyExists(Long id) throws NotFoundException{
        return movimentacaoRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }


}
