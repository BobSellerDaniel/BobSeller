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
import core.dao.IndexAdminTablasDAO;

@Service
public class ModulosService implements ModulosController{
	
	@Autowired
	private ModulosDAO modulosDaos;
	
	@Autowired
	private IndexAdminTablasDAO IndexAdminTablasDAO;
	
	@Override
	public String getHook(String hook, Model model, HttpServletRequest request) {		
		
		List<BOBHtmlElement> theader = new ArrayList<>();
		theader.add(BOBHtmlElement.getTh("Id", true,"idModulos",""));
		theader.add(BOBHtmlElement.getTh("Menu", false,"idMenu",""));
		theader.add(BOBHtmlElement.getTh("Nombre", false,"nombre",""));
		theader.add(BOBHtmlElement.getTh("Descripción", false,"descripcion",""));
		theader.add(BOBHtmlElement.getTh("Versión", false,"version",""));
		theader.add(BOBHtmlElement.getTh("Clase", false,"clase",""));
		theader.add(BOBHtmlElement.getTh("Paquete", false,"paquete",""));
		theader.add(BOBHtmlElement.getTh("Titulo", false,"titulo",""));
		theader.add(BOBHtmlElement.getTh("ACL", false,"acl",""));
		theader.add(BOBHtmlElement.getTh("Estado", false,"estado",""));
		
		BOBHtml crud = new 	BOBHtml();
		crud.setIsForm(true);
		crud.setRequest(request);
		crud.setTitle("Administración de módulos");
		crud.setTheader(theader);
		List<BOBCRUD> crudlist = new ArrayList<>();
		crudlist.add(BOBCRUD.create);
		crudlist.add(BOBCRUD.delete);
		crudlist.add(BOBCRUD.retrieve);
		crudlist.add(BOBCRUD.update);
		crud.setCrud(crudlist);
		crud.setNunRegistro(IndexAdminTablasDAO.findByNombre("modulos").getFilas());
		crud.setDescription("cualquier cosa");
		crud.setExportData(true);
		crud.setFieldList(modulosDaos.findAll());
		crud.setIdHTML("tablaAdmin");
		crud.setImportData(true);
		
		String OuputHtml = crud.OuputHtml();
		
		model.addAttribute("tab",request.getParameter("tabs"));
		model.addAttribute("BOB_LIST",OuputHtml);
		return "modulos";
	}
	
	@Override
	public Boolean instalar(List hooks) {return null;}

	@Override
	public Boolean desinsatalar(List hooks) {return null;}

}

