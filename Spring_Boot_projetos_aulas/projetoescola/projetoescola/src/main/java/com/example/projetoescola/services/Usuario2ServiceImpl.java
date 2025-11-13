package com.example.projetoescola.services;

import org.springframework.stereotype.Service;

import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.dtos.RegraNegocioException;
import com.example.projetoescola.dtos.Usuario2RequestDTO;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.models.Usuario2;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.Usuario2Repository;

@Service
public class Usuario2ServiceImpl implements Usuario2Service {
    
    private Usuario2Repository usuarioRepository;
    

    public Usuario2ServiceImpl(Usuario2Repository usuarioRepository){

        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void salvar(Usuario2RequestDTO usuarioRequestDTO) {


        Usuario2 usuario = new Usuario2();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setSenha(usuarioRequestDTO.getSenha());
        usuario.setConfirmarSenha(usuarioRequestDTO.getConfirmarSenha());
        usuario.setDataDeNascimento(usuarioRequestDTO.getDataDeNascimento());
        usuarioRepository.save(usuario);
        
    }
}
