package com.apirest_microservicio.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.apirest_microservicio.model.Curso;

import jakarta.annotation.PostConstruct;

@RestController
@ComponentScan(basePackages = {"com.apirest_microservicio.controllers"}) // Indica que será aqui la base para los controladores y detecte aqui mero 
public class CursoControllers {
	
	private List<Curso> cursos;
	@PostConstruct // Cuando se instancia el constructor, se ejecuta esto 
	public void init() {
		cursos = new ArrayList<>();
		cursos.add(new Curso("Spring 0", 25, "mañana"));
		cursos.add(new Curso("Spring 1", 26, "tarde"));
		cursos.add(new Curso("Spring 2", 27, "noche"));
		cursos.add(new Curso("Spring 3", 28, "mañana"));
		cursos.add(new Curso("Spring 4", 29, "tarde"));
		cursos.add(new Curso("Spring 5", 30, "noche"));
		cursos.add(new Curso("Spring 6", 31, "mañana"));
		cursos.add(new Curso("Spring 7", 32, "tarde"));
		cursos.add(new Curso("Spring 8", 33, "noche"));
		cursos.add(new Curso("Spring 9", 34, "mañana"));
	}
	
	@GetMapping (value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> getCursos(){
		return cursos;
	}
	
	
	@GetMapping (value="curso", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso getCurso() {
		return new Curso("Java", 100, "Mañana");
	}
	
	@GetMapping (value="curso/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> getCursoById(@PathVariable("name") String nombre) {
		List<Curso> aux = new ArrayList<>();
		for( Curso c:cursos) {
			if(c.getNombre().contains(nombre)) {
				aux.add(c);
			}
		}
		
		return aux;
	}
}
