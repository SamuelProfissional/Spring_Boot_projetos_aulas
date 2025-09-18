package com.example.projetoescola;

import java.util.List;
import com.example.projetoescola.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.models.Diciplina;
import com.example.projetoescola.models.Professor;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.DiciplinaRepository;

@SpringBootApplication
public class ProjetoescolaApplication /*~~(Could not parse as Java)~~>*//*~~(Could not parse as Java)~~>*/{


	@Bean// cria e salva os objetos
	// @Autowired pega o objeto e instancia ele automaticamente, ex: (da new Objeto) automaticamente
	public CommandLineRunner init(@Autowired CursoRepository cursoRepository,
	@Autowired CategoriaCursoRepository categoriaCursoRepository,@Autowired DiciplinaRepository diciplinaRepository, @Autowired ProfessorRepository professorRepository) {

		return args -> {
			Professor p1 = professorRepository.save(new Professor(null,"Dougla Augusto",3000.0));
			Professor p2 = professorRepository.save(new Professor(null,"Ana",2500.0));
			Professor p3 = professorRepository.save(new Professor(null,"Dougla Roberto",4000.0));
			Professor p4 = professorRepository.save(new Professor(null,"Maria",3500.0));
			Professor p5 = professorRepository.save(new Professor(null,"Vitor Araujo",3300.0));
			Professor p6 = professorRepository.save(new Professor(null,"Leonardo",4500.0));
			List<Professor> listarProfessor = professorRepository.findAll();
			// Inserir categorias
			CategoriaCurso c1 = categoriaCursoRepository.save(new CategoriaCurso(null,"Tecnólogo",null));
			cursoRepository.save(new Curso(null, "Analise de Sistemas", 2000, null,null));
			cursoRepository.save(new Curso(null, "Jogos Digitais", 2050, null,null));
			List<Curso> listaCursos = cursoRepository.findAll();
			//=========================================================
			diciplinaRepository.salvar(new Diciplina(null,"Progamação-Web"));
			List<Diciplina> listaDiciplinas = diciplinaRepository.listarTodos();

			//Associar  cursos à categoria
			listaCursos.forEach(curso ->{
				curso.setDiciplinas(listaDiciplinas);
				curso.setCategoriaCurso(c1);
				cursoRepository.save(curso);

			});

			System.out.println(("Cursos que começa com 'Jogos'"));
			cursoRepository.findByNomeLike("Jogos%").forEach (System.out::println);

			System.out.println(("PROFESSORES QUE COMEÇÃO COM O MESMO NOME"));
			professorRepository.findByNomeLike("Douglas%").forEach (System.out::println);  
			//  terminar 
			System.out.println(("Professores com salário maior"));
			professorRepository.findBySalarioGreaterThan(3000.0).forEach (System.out::println);  

			System.out.println(("Professores com salário menor ou igual"));
			professorRepository.findBySalarioLessThanEqual(4500.0).forEach (System.out::println);  
		};
	
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}

}
