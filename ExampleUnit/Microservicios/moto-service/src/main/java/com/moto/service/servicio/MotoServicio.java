package com.moto.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.entidad.Moto;
import com.moto.service.repositorio.MotoRepositorio;

@Service
public class MotoServicio {
	
	@Autowired
	private MotoRepositorio motoRepositorio;

	public List<Moto> getAll(){
		return motoRepositorio.findAll();
	}
	
	public Moto getMotoById(int idMoto) {
		return motoRepositorio.findById(idMoto).orElse(null);
	}
	
	public Moto saveMoto(Moto moto) {
		Moto nuevaMoto = motoRepositorio.save(moto);
		return nuevaMoto;
	}
	
	public List<Moto> motoByIdUsuario(Integer idUsuario){
		return motoRepositorio.findByIdUsuario(idUsuario);
	}
}
