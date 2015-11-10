package core.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import core.controller.ModulosController;
import core.dao.MenusDAO;

@Service
public class MenusService implements ModulosController{
	
	@Autowired
	private MenusDAO menusDao;
	
	public String getHook(String hook, Model model, HttpServletRequest request) {
		model.addAttribute("MENUDATOS",menusDao.findAll());
		return "menu";
	}
	
	@Override
	public Boolean instalar(List hooks) {
		return null;
	}

	@Override
	public Boolean desinsatalar(List hooks) {
		return null;
	}
	
}
