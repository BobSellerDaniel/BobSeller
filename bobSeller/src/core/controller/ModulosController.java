package core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


public interface ModulosController {
	
	public Boolean instalar(List hooks);
	public Boolean desinsatalar(List hooks);
	public String getHook(String hook, Model model, HttpServletRequest request);
		
}
