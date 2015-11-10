package core.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import core.controller.ModulosController;
import core.dao.ModulosDAO;

@Service
public class ModulosService implements ModulosController{
	
	@Autowired
	private ModulosDAO modulosDaos;	
		
	@Override
	public String getHook(String hook, Model model, HttpServletRequest request) {
		System.out.println("---: "+modulosDaos.findAll());
		model.addAttribute("TABLA","dd");
		return "modulos";
	}
	
	@Override
	public Boolean instalar(List hooks) {return null;}

	@Override
	public Boolean desinsatalar(List hooks) {return null;}

}
