package com.usuario.service.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.servicio.UsuarioServicio;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

		@Autowired
		private UsuarioServicio usuarioService;
		
		@GetMapping
		public ResponseEntity<List<Usuario>> listarUsuarios(){ // ESTO LISTA TODOS LOS USUARIOS CON GETALL
			List<Usuario> usuarios = usuarioService.getAll();
			if(usuarios.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(usuarios);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Usuario> obtenerUsuarios(@PathVariable("id") int idUsuario) { //ESTO LISTA USUARIOS POR ID
			Usuario usuario = usuarioService.getUsuarioById(idUsuario);
			if(usuario == null){
				return ResponseEntity.notFound().build();				
			}
			return ResponseEntity.ok(usuario);
		}
		
		@PostMapping
		public ResponseEntity<Usuario> guardarUsuarios(@RequestBody Usuario usuario){
			Usuario nuevoUsuario = usuarioService.saveUsuario(usuario);
			return ResponseEntity.ok(nuevoUsuario);
		}
		
		@GetMapping("/carros/{idUsuario}")
		public ResponseEntity <List<Carro>> listarCarros(@PathVariable("idUsuario") int idUsuario) { //ESTO LISTA USUARIOS POR ID
			Usuario usuario = usuarioService.getUsuarioById(idUsuario);
			if(usuario == null){
				return ResponseEntity.notFound().build();				
			}
			List<Carro> carros = usuarioService.getCarros(idUsuario);
			return ResponseEntity.ok(carros);
		}
		
		@GetMapping("/motos/{idUsuario}")
		public ResponseEntity <List<Moto>> listarMotos(@PathVariable("idUsuario") int idUsuario) { //ESTO LISTA USUARIOS POR ID
			Usuario usuario = usuarioService.getUsuarioById(idUsuario);
			if(usuario == null){
				return ResponseEntity.notFound().build();				
			}
			List<Moto> motos = usuarioService.getMotos(idUsuario);
			return ResponseEntity.ok(motos);
		}
		
	
}
