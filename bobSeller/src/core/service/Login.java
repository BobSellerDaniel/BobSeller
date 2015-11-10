package core.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import core.controller.ModulosController;

@Service
public class Login implements ModulosController {

	@SuppressWarnings("rawtypes")
	@Override
	public Boolean instalar(List hooks) {
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Boolean desinsatalar(List hooks) {
		return null;
	}

	@Override
	public String getHook(String hook, Model model, HttpServletRequest request) {
		model.addAttribute("MODLOG","este valor biene del modulos Loguin");
		return "login-info";
	}

}
