package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Paises;

@Repository
public class UsuarioRepositoryClass implements UsuarioRepository {

	 /*private final UsuarioRepositoryInterfaceJpa jpaR;
	 
	 @Autowired
	 public UsuarioRepositoryClass(UsuarioRepositoryInterfaceJpa jpaR) {
		 this.jpaR = jpaR;
	 }*/
	
	@Autowired
	UsuarioRepositoryInterfaceJpa jpaR;

	    
	 @Override
	    public Map<String, Object> crearUsuario(Paises usr) {
	        Map<String, Object> response = new HashMap<>();
	        
	        try {
	            jpaR.save(usr);
	            response.put("status", 200);
	            response.put("descripcion", "Guardado");
	            response.put("detalle", jpaR.findAll());
	        } catch (Exception e) {
	            response.put("status", 500);
	            response.put("descripcion", "Error: " + e.getMessage());
	            response.put("detalle", usr);
	        }
	        
	        return response;
	    }


	@Override
	public Map<String, Object> listarUsuariosById(long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Paises usrSearchById = jpaR.findById(id).orElse(null);
			if(usrSearchById == null) {
				response.put("Status", 404);
				response.put("Descripcion", "No Encontrado");
				response.put("Registro(s)", null);
			}else {
				response.put("Status", 200);
				response.put("Descripcion", "Ok");
				response.put("Registro(s)", usrSearchById);
			}
			
		}catch(Exception e) {
			response.put("Status", 500);
			response.put("Descripcion", e.getMessage());
			response.put("Registro(s)", null);
		}
		
		return response;
	}


	@Override
	public Map<String, Object> listarUsuarioAll() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<Paises> usrFindAll = jpaR.findAll();
			if(usrFindAll.isEmpty()) {
				response.put("Status", 404);
				response.put("Descripcion", "No hay registros");
				response.put("Registro(s)", null);
			}else {
				response.put("Status", 200);
				response.put("Descripcion", "Ok");
				response.put("Registros", usrFindAll.size());
				response.put("Registro(s)", usrFindAll);
			}
			
		}catch(Exception e) {
			response.put("Status", 500);
			response.put("Descripcion", "Error: "+e.getMessage());
			response.put("Registro(s)", null);	
		}
		return response;
	}
	
	
	@Override	
	public Map<String, Object> searchUserByEmail(String namePais){
		Map<String, Object> response = new HashMap<>();
		try {
			Paises usrByEmail = (Paises) jpaR.findByNamePais(namePais);
			//List<Usuario> usrByEmail = jpaR.findByEmail(email);
			
			if(usrByEmail == null ) {
				response.put("Status", 404);
				response.put("Descripción", "No hay registro(s)");
				response.put("Registro(s)", null);
			}else {
				response.put("Status", 200);
				response.put("Descripción", "Ok");
				response.put("Registro(s)", usrByEmail);
			}
			
		}catch(Exception e) {
			response.put("Status", 500);
			response.put("Descripción", "Error: "+e.getMessage());
			response.put("Registro(s)", null);
		}
		
		return response;
	}


	@Override
	public Map<String, Object> updateUsrById(Long id, Paises us) {
		Map<String, Object> response = new HashMap<>();
		try {
			Paises usrById = jpaR.findById(id).orElse(null);
			if( usrById == null ) {
				response.put("Status", 404);
				response.put("Descripción", "No hay registros con el id");
				response.put("Registro(s)", null);
			}else {
	            us.setIdPais(id);
				try {
					//Usuario usrByIdUpdate = jpaR.save(us);					
					Paises usrByIdUpdate = jpaR.save(us);
					response.put("Status", 200);
					response.put("Descripción", "Actualizado");
					response.put("Registro Anterior", usrById);
					response.put("Registro Actualizado", usrByIdUpdate);
				}catch(Exception ee) {
					response.put("Status", 500);
					response.put("Descripción", "Error actualizacion: "+ee.getMessage());
					response.put("Registro(s)", null);
				}
				
			}
			
		}catch(Exception e) {
			response.put("Status", 500);
			response.put("Descripción", "Error: "+e.getMessage());
			response.put("Registro(s)", null);
		}
		
		return response;
	}


	@Override
	public Map<String, Object> deleteById(Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Paises usr = jpaR.findById(id).orElse(null);
			if(usr == null) {
				response.put("Status", 404);
				response.put("Descripción", "Error: No hay registros con el id");
				response.put("Registro(s)", null);
			}else {				
				try {
					jpaR.deleteById(id);
					response.put("Status", 500);
					response.put("Descripción", "Eliminado");		
				}catch(Exception ee) {
					response.put("Status", 500);
					response.put("Descripción", "Error2: "+ee.getMessage());
					response.put("Registro(s)", null);
				}
						
			}
			
		}catch(Exception e) {
			response.put("Status", 500);
			response.put("Descripción", "Error: "+e.getMessage());
			response.put("Registro(s)", null);
		}
		
		return response;
	}

}
