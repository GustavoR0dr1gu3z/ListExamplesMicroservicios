package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Paises;
import service.UsuarioService;

@RestController
@RequestMapping("/paises")
public class CrudController {	
	
	@Autowired
	UsuarioService usuarioService;

	
	@GetMapping(value="/inicio")
	public String saludar() {
		return "hola";
	}
	
	//--> CRUD
		//--> CREAR USUARIO
			@PostMapping(value="/crear", produces=MediaType.APPLICATION_JSON_VALUE)
			public Map<String, Object> crearUsuario(@RequestBody Paises usrBody){				
				return usuarioService.crearUsuario(usrBody);
			}
		//--> READ USUARIO (LISTADO)
			//--> Listando todos los registros
				@GetMapping(value="/listadoAll", produces=MediaType.APPLICATION_JSON_VALUE)
				public Map<String, Object> listadoUserAll(){
					return usuarioService.listarUsuarioAll();
				}
			//--> Listado por Id
				@GetMapping(value="/listado/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
				public Map<String, Object> listadoUserById(@PathVariable("id") long id){
					return usuarioService.listarUsuariosById(id);
				}
			//--> Listado por Email
				@GetMapping(value="/listadoEmail/", produces=MediaType.APPLICATION_JSON_VALUE)
				public Map<String, Object> listUserByEmail(@RequestParam("pais") String namePais){
					return usuarioService.searchUserByEmail(namePais);
				}
		//-->UPDATE USUARIO
			//-->Update By Id
				@PutMapping(value="/update/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
				public Map<String, Object> updateUsrById(@PathVariable("id") Long id, @RequestBody Paises usrBody){
					return usuarioService.updateUsrById(id, usrBody);
				}
				
		//--> DELETE USUARIO
			//--> Delte By Id
				@DeleteMapping(value="/eliminar/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
				public Map<String, Object> deleteUserById(@PathVariable("id") Long id){
					return usuarioService.deleteUsrById(id);
				}

}
