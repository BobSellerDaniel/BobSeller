package core.dao;

import core.pojo.Usuario;

public interface UsuarioDAO {
	
	public Usuario findByUsername(String usuario);

}
