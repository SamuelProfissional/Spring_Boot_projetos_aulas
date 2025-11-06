package com.example.projetoescola.services;

import org.springframework.stereotype.Service;

import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.dtos.RegraNegocioException;
import com.example.projetoescola.dtos.UsuarioRequestDTO;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.models.Usuario;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    private UsuarioRepository usuarioRepository;
    

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){

        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void salvar(UsuarioRequestDTO usuarioRequestDTO) {


        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setSenha(usuarioRequestDTO.getSenha());
        usuario.setConfirmarSenha(usuarioRequestDTO.getConfirmarSenha());
        usuario.setDataDeNascimento(usuarioRequestDTO.getDataDeNascimento());
        usuarioRepository.save(usuario);
        
    }
}
