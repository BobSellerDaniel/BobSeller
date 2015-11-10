package core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.UsuarioDAO;

@Service
public class UsuarioService {

	@SuppressWarnings("unused")
	@Autowired
	private UsuarioDAO usuarioDAO;
	
}
