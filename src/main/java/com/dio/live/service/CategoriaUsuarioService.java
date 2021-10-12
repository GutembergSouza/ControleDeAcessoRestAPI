package com.dio.live.service;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.repository.CategoriaUsuarioRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaUsuarioService {
    CategoriaUsuarioRepository categoriaUsuarioRepository;

    @Autowired
    public CategoriaUsuarioService(CategoriaUsuarioRepository categoriaUsuarioRepository) {
        this.categoriaUsuarioRepository = categoriaUsuarioRepository;
    }


    public CategoriaUsuario create(CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public List<CategoriaUsuario> listAll(){
        return categoriaUsuarioRepository.findAll();
    }


    public CategoriaUsuario findById(Long id)throws NotFoundException{
        verifyExists(id);
       return categoriaUsuarioRepository.findById(id).get();
    }

    public void delete(Long id) throws NotFoundException{
        verifyExists(id);
        categoriaUsuarioRepository.deleteById(id);
    }

   public CategoriaUsuario update(CategoriaUsuario categoriaUsuario)throws NotFoundException{
        verifyExists(categoriaUsuario.getId());
        return categoriaUsuarioRepository.save(categoriaUsuario);
   }

    protected CategoriaUsuario verifyExists(Long id)throws NotFoundException {
        return categoriaUsuarioRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }
}
