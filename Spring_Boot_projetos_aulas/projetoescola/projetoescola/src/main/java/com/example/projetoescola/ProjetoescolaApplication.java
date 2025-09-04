package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.models.Diciplina;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.DiciplinaRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	@Bean// cria e salva os objetos
	// @Autowired pega o objeto e instancia ele automaticamente, ex: (da new Objeto) automaticamente
	public CommandLineRunner init(@Autowired CursoRepository cursoRepository,
	@Autowired CategoriaCursoRepository categoriaCursoRepository,@Autowired DiciplinaRepository diciplinaRepository) {

		return args -> {
			// Inserir categorias
			CategoriaCurso c1 = categoriaCursoRepository.salvar(new CategoriaCurso(null,"Tecnólogo"));
			cursoRepository.salvar(new Curso(null, "teste", 2000));
			cursoRepository.salvar(new Curso(null, "teste2", 2050));
			List<Curso> listaCursos = cursoRepository.obterTodos();
			//=========================================================
			diciplinaRepository.salvar(new Diciplina(null,"Progamação-Web"));
			List<Diciplina> listaDiciplinas = diciplinaRepository.listarTodos();

			//Associar  cursos à categoria
			listaCursos.forEach(curso ->{
				curso.setDiciplinas(listaDiciplinas);
				curso.setCategoriaCurso(c1);
				cursoRepository.salvar(curso);

			});

			listaCursos.forEach(System.out::println);

		};
	
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}

}
