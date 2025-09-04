package com.example.projetoescola.repositories;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaCursoRepository {

    @Autowired // e como se estivese instanciando um objeto (Ex: Objeto objeto = new Objeto)
    private EntityManager entityManager;
    @Transactional // Essa parte do código deve ser executada dentro de uma transação do banco de dados. ou tudo funciona ou nada da certo
    public CategoriaCurso salvar(CategoriaCurso categoriaCurso) {

        categoriaCurso = entityManager.merge(categoriaCurso);
        return categoriaCurso;
    }

    public List<CategoriaCurso> listarTodos() {
        String jpql = "SELECT c FROM CategoriaCurso c";
        return entityManager.createQuery(
                jpql, CategoriaCurso.class).getResultList();
    }

}
