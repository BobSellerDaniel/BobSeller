package core.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import core.component.BOBHtmlElement;
import core.component.BOBHtmlTag;
import core.component.BOBCRUD;
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
		
		List<BOBHtmlElement> theader = new ArrayList<>();
										 
		theader.add(BOBHtmlElement.getTh("id", true,"",""));
		theader.add(BOBHtmlElement.getTh("IdMenu", true,"",""));
		theader.add(BOBHtmlElement.getTh("nombre", true,"",""));
		theader.add(BOBHtmlElement.getTh("descripcion", true,"",""));
		theader.add(BOBHtmlElement.getTh("version", true,"",""));

//		theader.add(new BOBHtmlElement(BOBHtmlTag.th,"Id", true, BOBFormat.number));
//		theader.add(new BOBHtmlElement(BOBHtmlTag.th,"IdMenu", false, BOBFormat.number));
//		theader.add(new BOBHtmlElement(BOBHtmlTag.th,"nombre", false, BOBFormat.string));
//		theader.add(new BOBHtmlElement(BOBHtmlTag.th,"descripcion", false, BOBFormat.string));
//		theader.add(new BOBHtmlElement(BOBHtmlTag.th,"version", false, BOBFormat.number));
//		theader.add(new BOBHtmlElement(BOBHtmlTag.th,"clase", false, BOBFormat.string));
		
		BOBHtml crud = new 	BOBHtml();
		crud.setIsForm(true);
		crud.setTitle("Administraciòn de mòdulos");
		crud.setTheader(theader);
		List<BOBCRUD> crudlist = new ArrayList<>();
		crudlist.add(BOBCRUD.create);
		crudlist.add(BOBCRUD.delete);
		crudlist.add(BOBCRUD.retrieve);
		crudlist.add(BOBCRUD.update);
		crud.setCrud(crudlist);
		
		crud.setDescription("cualquier cosa");
		crud.setExportData(true);
		List<List<String>> fieldList = new ArrayList<List<String>>();
		/// llenar la tabla
		crud.setFieldList(fieldList);
		crud.setIdHTML("tablaAdmin");
		crud.setImportData(true);
		
		 String OuputHtml = crud.OuputHtml();
		
		//crud.setFields(theader);
		
		System.out.println("get tab seleccionada : "+crud.toString());
		model.addAttribute("tab",request.getParameter("tabs"));
		model.addAttribute("BOB_LIST",OuputHtml);
		return "modulos";
	}
	
	@Override
	public Boolean instalar(List hooks) {return null;}

	@Override
	public Boolean desinsatalar(List hooks) {return null;}

}

