package com.example.projetoescola.services;

import org.springframework.stereotype.Service;

import com.example.projetoescola.dtos.CategoriaCursoRequestDTO;
import com.example.projetoescola.dtos.CursoDTO;
import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.dtos.RegraNegocioException;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;

@Service
public class CategoriaCursoServiceImpl implements CategoriaCursoService {

    
    private CategoriaCursoRepository categoriaCursoRepository;
    private CursoRepository cursoRepository;

    public CategoriaCursoServiceImpl(CategoriaCursoRepository categoriaCursoRepository,CursoRepository cursoRepository){

        this.cursoRepository = cursoRepository;
        this.categoriaCursoRepository = categoriaCursoRepository;

    }

    @Override
    public void salvar(CategoriaCursoRequestDTO categoriaCursoRequestDTO) {

        

        CategoriaCurso categoria = new CategoriaCurso();
        categoria.setNome(categoriaCursoRequestDTO.getNome());
        categoriaCursoRepository.save(categoria);
        
    }

    // DTO transferencia de dados
 
    
}
