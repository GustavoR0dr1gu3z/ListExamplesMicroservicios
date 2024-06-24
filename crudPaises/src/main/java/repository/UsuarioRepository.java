package repository;

import java.util.Map;

import model.Paises;

public interface UsuarioRepository{
	Map<String, Object> crearUsuario(Paises usr);
	
	Map<String, Object> listarUsuariosById(long id);
	Map<String, Object> listarUsuarioAll();
	Map<String, Object> searchUserByEmail(String email);
	
	Map<String, Object> updateUsrById(Long id, Paises us);
	
	Map<String, Object> deleteById(Long id);
}
