package com.apirest_microservicio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
class ApplicationTests {
	
	@Autowired
	MockMvc mock;

	// probar aqui los metodos, uno de ellos, ej: Get
	void testCursos() throws Exception{
		mock.perform(get("/cursos")).andDo(print());
	}
	

}
