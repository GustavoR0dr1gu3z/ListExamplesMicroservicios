package service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Paises;
import repository.UsuarioRepository;

@Service
public class UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioClass;

    public Map<String, Object> crearUsuario(Paises usr) {
        return usuarioClass.crearUsuario(usr);
    }
    
    public Map<String, Object> listarUsuariosById(long id){
    	return usuarioClass.listarUsuariosById(id);
    }
    
    public Map<String, Object> listarUsuarioAll(){
    	return usuarioClass.listarUsuarioAll();
    }

	public Map<String, Object> searchUserByEmail(String email) {
		return usuarioClass.searchUserByEmail(email);
	}
	
	public Map<String, Object> updateUsrById(long id, Paises usr){
		return usuarioClass.updateUsrById(id, usr);
	}
	
	public Map<String, Object> deleteUsrById(Long id){
		return usuarioClass.deleteById(id);
	}

}
