package com.carro.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carro.service.entidad.Carro;
import com.carro.service.repositorio.CarroRepository;


@Service
public class CarroServicio {
	
	@Autowired
	private CarroRepository carroRepository;
	
	public List<Carro> getAll(){
		return carroRepository.findAll();
	}
	
	public Carro getCarroById(int idCarro) {
		return carroRepository.findById(idCarro).orElse(null);
	}
	
	public Carro saveCarro(Carro carro) {
		Carro nuevoCarro = carroRepository.save(carro);
		return nuevoCarro;
	}
	
	public List<Carro> carroByIdUsuario(Integer idUsuario){
		return carroRepository.findByIdUsuario(idUsuario);
	}
}
