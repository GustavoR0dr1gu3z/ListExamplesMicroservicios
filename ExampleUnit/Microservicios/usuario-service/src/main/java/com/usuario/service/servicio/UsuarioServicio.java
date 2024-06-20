package com.usuario.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UsuarioRepositorio  usuarioRepositorio;
	

	public List<Carro> getCarros(int idUsuario){
		List <Carro> carros = restTemplate.getForObject("http://localhost:8002/carro/usuario/"+idUsuario, List.class);
		return carros;
	}
	
	public List<Moto> getMotos(int idUsuario){
		List <Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/usuario/"+idUsuario, List.class);
		return motos;
	}
	
	
	
	public List<Usuario> getAll(){
		return usuarioRepositorio.findAll();
	}
	
	public Usuario getUsuarioById(int idUsuario) {
		return usuarioRepositorio.findById(idUsuario).orElse(null);
	}
	
	public Usuario saveUsuario(Usuario usuario) {
		Usuario nuevoUsr = usuarioRepositorio.save(usuario);
		return nuevoUsr;
	}
}
