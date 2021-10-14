package com.dio.live.service;

import com.dio.live.model.Usuario;
import com.dio.live.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario create(Usuario usuario){
       return usuarioRepository.save(usuario);
    }

    public List<Usuario> listAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) throws NotFoundException{
        return verifyExists(id);
    }

    public Usuario update(Usuario usuario)throws NotFoundException{
        verifyExists(usuario.getId());
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id)throws NotFoundException{
        verifyExists(id);
        usuarioRepository.deleteById(id);
    }

    public Usuario verifyExists(Long id) throws NotFoundException{
        return usuarioRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }
}
