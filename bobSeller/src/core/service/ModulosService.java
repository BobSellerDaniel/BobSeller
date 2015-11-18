package core.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	private HttpServletRequest request;
	private Model model;
	private BOBHtml crud = new 	BOBHtml();
	
	@Autowired
	private ModulosDAO modulosDaos;
	
	@Autowired
	private IndexAdminTablasDAO IndexAdminTablasDAO;
	
	@Override
	public String getHook(String hook, Model model, HttpServletRequest request) {		
		
		this.request = request;
		this.model = model;
		
		String Vtab = (String)request.getParameter("vtab");
		String VCrear = (String)request.getParameter("vCrear");
		
		if((Vtab != null && 0 == "modulosTab".compareTo(Vtab)) || (VCrear != null && 0 == "modulosTab".compareTo(VCrear))){tabs("Administración de módulos",true,false,false); AdminModulos();}
		else if((Vtab != null && 0 == "hooksTab".compareTo(Vtab)) || (VCrear != null && 0 == "hooksTab".compareTo(VCrear))){tabs("Administración de Hooks",false,true,false); AdminHooks();}
		else if((Vtab != null && 0 == "vistasTab".compareTo(Vtab)) || (VCrear != null && 0 == "vistasTab".compareTo(VCrear))){tabs("Administración de Vistas",false,false,true); AdminVistas();}
		else{tabs("Administración de módulos",true,false,false); AdminModulos();}
		
		model.addAttribute("BOB_LIST",crud.OuputHtml());
		
		return "modulos";
	}
	
	public void tabs(String titulo, boolean modulos, boolean hooks, boolean vistas){
		crud.setTitle(titulo);
		List<BOBHtmlElement> tabs = new ArrayList<>();
		tabs.add(BOBHtmlElement.getTab("MODULOS", "modulosTab", "tabs", "../img/big/modulos.png", "gold", modulos));
		tabs.add(BOBHtmlElement.getTab("HOOKS", "hooksTab", "tabs", "../img/big/hook.png","#B1D6FC", hooks));
		tabs.add(BOBHtmlElement.getTab("VISTAS", "vistasTab", "tabs", "../img/big/vista.png","#D8B1FC", vistas));
		crud.setTabs(tabs);
	}
	
	public void AdminModulos(){
		
		List<BOBHtmlElement> theader = new ArrayList<>();
		theader.add(BOBHtmlElement.getTh("Id", true,"idModulos","centrar","5%"));
		theader.add(BOBHtmlElement.getTh("Menu", false,"idMenu","centrar","5%"));
		theader.add(BOBHtmlElement.getTh("Nombre", false,"nombre","izquierda","10%"));
		theader.add(BOBHtmlElement.getTh("Descripción", false,"descripcion","izquierda","25%"));
		theader.add(BOBHtmlElement.getTh("Versión", false,"version","centrar","6%"));
		theader.add(BOBHtmlElement.getTh("Clase", false,"clase","izquierda","12%"));
		theader.add(BOBHtmlElement.getTh("Paquete", false,"paquete","centrar","5%"));
		theader.add(BOBHtmlElement.getTh("Titulo", false,"titulo","izquierda","11%"));
		theader.add(BOBHtmlElement.getTh("ACL", false,"acl","centrar","15%"));
		theader.add(BOBHtmlElement.getTh("Estado", false,"estado","centrar","5%"));
		
		
		crud.setRequest(request);
		crud.setTheader(theader);
		Set<BOBCRUD> crudlist = new HashSet();
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
	}
	
	public void AdminHooks(){
		AdminModulos();
		//model.addAttribute("BOB_LIST",crud.OuputHtml());
	}
	
	public void AdminVistas(){
		AdminModulos();
		//model.addAttribute("BOB_LIST",crud.OuputHtml());
	}
	
	@Override
	public Boolean instalar(List hooks) {return null;}

	@Override
	public Boolean desinsatalar(List hooks) {return null;}

}

