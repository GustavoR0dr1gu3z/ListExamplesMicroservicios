package com.apirest_microservicio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ApplicationTests {
	
	@Autowired
	MockMvc mock;
	@Test
	@Order(0)
	
	void testCurso() throws Exception {
		mock.perform(get("/cursos")).andDo(print());
	}
	
	@Test
	@Order(1)
	void eliminarCurso() throws Exception{
		mock.perform(delete("/curso/Spring 0")).andDo(print());
	}

	@Test
	@Order(2)
	void testCursoEliminado() throws Exception {
		mock.perform(get("/cursos")).andDo(print());
	}
	
	@Test
	@Order(3)
	void putCurso() throws Exception {
		mock.perform(
				put("/curso")
				.contentType(MediaType.APPLICATION_JSON)
				.content("\"{\\\"nombre\\\": \\\"Spring 0\\\",\\\"duracion\\\": 25,\\\"horario\\\": \\\"mañana\\\"}\"")
		).andDo(print());
	}
	
	@Test
	@Order(4)
	void postCurso() throws Exception {
		mock.perform(
				post("/curso")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"nombre\": \"Spring 0\",\"duracion\": 25,\"horario\": \"tarde\"}")
		).andDo(print());
	}
	
	@Test
	@Order(5)
	void testCursoAll() throws Exception {
		mock.perform(get("/cursos")).andDo(print());
	}
	
	

}
