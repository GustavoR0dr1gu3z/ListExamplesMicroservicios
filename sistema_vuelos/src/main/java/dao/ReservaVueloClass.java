package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.Vuelo;
import model.Vuelo.DetallesReserva;

public class ReservaVueloClass implements ReservaVueloDao {
	
	@Autowired
	ReservaVueloJpa vueloJpa;

	@Override
	public Vuelo reservaVuelo(Vuelo vuelo) {		
		DetallesReserva response = new DetallesReserva();
		Vuelo vueloStatus = new Vuelo();
		try {
			String precio = "154,50";
			vueloJpa.save(vuelo.getReservacionDetalles());
						
			vueloStatus.setStatus(200);
			vueloStatus.setDescripcion("Se ha generado correctamente la reserva");		
		
			response.setOrigen(vuelo.getReservacionDetalles().getOrigen());
			response.setDestino(vuelo.getReservacionDetalles().getDestino());
			response.setDias(vuelo.getReservacionDetalles().getDias());
			response.setHotel(vuelo.getReservacionDetalles().getHotel());
			response.setRecamaras(vuelo.getReservacionDetalles().getRecamaras());
			response.setPrecio(precio);
			
			vueloStatus.setReservacionDetalles(response);		
			
			
		}catch(Exception e) {
			vuelo.setStatus(400);
			vuelo.setDescripcion("Error al generar la reserva: "+e.getMessage());	
			vuelo.setReservacionDetalles(response);
		}		
		
		return vueloStatus;
	}

}
