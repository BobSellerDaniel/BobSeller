package core.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import core.component.BOBHtmlElement;
import core.component.BOBHtmlTag;
import core.component.BOBFormat;
import core.component.BOBHtml;
import core.controller.ModulosController;
import core.dao.ModulosDAO;

@Service
public class ModulosService implements ModulosController{
	
	@Autowired
	private ModulosDAO modulosDaos;	
	
	
	@Override
	public String getHook(String hook, Model model, HttpServletRequest request) {
		//System.out.println("---: "+modulosDaos.findAll());
		BOBHtml crud = new 	BOBHtml();
		List<BOBHtmlElement> theader = new ArrayList<>();
		theader.add(new BOBHtmlElement(BOBHtmlTag.th,"ID", true, BOBFormat.number));
		theader.add(new BOBHtmlElement(BOBHtmlTag.th,"Menu", false, BOBFormat.number));
		theader.add(new BOBHtmlElement(BOBHtmlTag.th,"ID", true, BOBFormat.number));
		theader.add(new BOBHtmlElement(BOBHtmlTag.th,"ID", true, BOBFormat.number));
		theader.add(new BOBHtmlElement(BOBHtmlTag.th,"ID", true, BOBFormat.number));
		theader.add(new BOBHtmlElement(BOBHtmlTag.th,"ID", true, BOBFormat.number));
		
		
		
		crud.setTheader(theader);
		System.out.println("get tab seleccionada : "+request.getParameter("tabs"));
		model.addAttribute("tab",request.getParameter("tabs"));
		return "modulos";
	}
	
	@Override
	public Boolean instalar(List hooks) {return null;}

	@Override
	public Boolean desinsatalar(List hooks) {return null;}

}

