package service;

import java.util.List;
import model.AgendaModel;

public interface AgendaServiceInterface {
	boolean agregarContacto(AgendaModel agenda);
	List<AgendaModel> recuperarContactos();
	void actualizarContacto(AgendaModel agenda);
	boolean eliminarContacto(int idContacto);
	AgendaModel buscarContacto(int idContacto);
}
