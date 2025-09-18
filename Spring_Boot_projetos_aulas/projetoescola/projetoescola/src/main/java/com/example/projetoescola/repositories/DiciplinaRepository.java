package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Diciplina;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository  //A anotação @Repository diz para o Spring que aquela classe é responsável por acessar o banco de dados.
public class DiciplinaRepository {
    @Autowired // e como se estivese instanciando um objeto (Ex: Objeto objeto = new Objeto)
    private EntityManager entityManager;
    @Transactional // Essa parte do código deve ser executada dentro de uma transação do banco de dados. ou tudo funciona ou nada da certo
    public Diciplina salvar(Diciplina diciplina) {

        diciplina = entityManager.merge(diciplina);
        return diciplina;
    }

    public List<Diciplina> listarTodos() {
        String jpql = "SELECT c FROM Diciplina c";
        return entityManager.createQuery(
                jpql, Diciplina.class).getResultList();
    }
}
