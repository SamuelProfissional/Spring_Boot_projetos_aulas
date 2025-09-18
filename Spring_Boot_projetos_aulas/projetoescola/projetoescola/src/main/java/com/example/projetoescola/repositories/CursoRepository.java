package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.projetoescola.models.Curso;


// Pergunta de prova o primeiro parametro e o tipo que vamos salvar e segundo é chave primaria 
public interface CursoRepository extends JpaRepository <Curso, Long>{

    // e como se estivese  criando a consulta no banco de dados 
    // = select * form curso wehere name = ""
    List<Curso> findByNomeLike(String nome);

    List<Curso> findBycargaHorariaGreaterThanEqual(Integer  cargaHoraria);

    List<Curso> findByNomeAndCargaHorariaGreaterThanEqual(String nome,Integer cargaHoraria);

    @Query("select c from Curso c where c.categoriaCurso.id = :idCategoria" )
    List<Curso> findByIdCategoria(Integer idCategoria);


            
}
