package repository;

import java.util.Map;

import model.Usuario;

public interface UsuarioRepository{
	Map<String, Object> crearUsuario(Usuario usr);
	
	Map<String, Object> listarUsuariosById(long id);
	Map<String, Object> listarUsuarioAll();
	Map<String, Object> searchUserByEmail(String email);
	
	Map<String, Object> updateUsrById(Long id, Usuario us);
	
	Map<String, Object> deleteById(Long id);
}
