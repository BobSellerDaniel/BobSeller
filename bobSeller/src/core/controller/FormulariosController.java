package core.controller;

import org.springframework.stereotype.Controller;

import core.component.ApplicationContextHolder;
import core.dao.ModulosDAOImpl;

@Controller
public class FormulariosController {
	
	

	public String crear(String TDatos, int i, int j, int k){
		
		//ModulosDAOImpl instancia = (ModulosDAOImpl) ApplicationContextHolder.getContext().getBean(TDatos);
		//String valor = instancia.ejemplo();
		
		return "creamos el formulario";
	}
	
}
