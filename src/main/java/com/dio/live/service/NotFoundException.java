package com.dio.live.service;

import com.dio.live.model.Movimentacao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception{

    public NotFoundException(Long id){
        super ("Element Not Found by id:"+ id.toString());
    }

    public NotFoundException(Movimentacao.MovimentacaoId movimentacaoId){
        super ("Element Not Found by id:"+ movimentacaoId.toString());
    }

}
