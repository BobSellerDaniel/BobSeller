package core.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import core.component.BOBCRUD;
import core.component.BOBHtml;
import core.component.BOBHtmlElement;
import core.component.BOBHtmlInputType;
import core.component.BOBHtmlTag;
import core.controller.ModulosController;
import core.dao.IndexAdminTablasDAO;
import core.dao.MenusDAO;

@Service
public class MenusService implements ModulosController{
	
	private HttpServletRequest request;
	private Model model;
	private BOBHtml crud = new BOBHtml();
	
	@Autowired
	private MenusDAO menusDao;
	
	@Autowired
	private IndexAdminTablasDAO IndexAdminTablasDAO;
	
	public String getHook(String hook, Model model, HttpServletRequest request) {
		this.request = request;
		this.model = model;
	
		if(0 == "HOOKMENU".compareTo(hook)){
			model.addAttribute("MENUDATOS",menusDao.findAll());
			return "menu";
		}
		else return ConstructorHTML();
	}
	
	public String ConstructorHTML(){
	
		String VCrear = (String) request.getParameter("vCrear");

		if (VCrear != null && 0 == "true".compareTo(VCrear)) {
			tabs("Crear Menus", true, false, false);
			CrearMenus();
		}else {
			tabs("Administración de Menus", true, false, false);
			ListarMenus();
		}
		
		return "menusAdmin";
	}
	
	private void tabs(String titulo, boolean b, boolean c, boolean d) {crud.setTitle(titulo);}

	private void CrearMenus(){
		
		List<BOBHtmlElement> tInputs = new ArrayList<>();
		tInputs.add(BOBHtmlElement.getInput("Id", "Menu", "Menu", "menu-idMenu", BOBHtmlInputType.text, true, "", ""));
		
		tInputs.add(BOBHtmlElement.getSelect("Padre", "idPadre", "Menu Padre", "menu-idPadre", BOBHtmlTag.select, true, "", "", menusDao.findAll(),"idMenu","titulo",(String)request.getAttribute("idMenu")));
		
		tInputs.add(BOBHtmlElement.getInput("Nombre", "nombre", "Nombre", "menu-nombre", BOBHtmlInputType.text, true, "", ""));	
		tInputs.add(BOBHtmlElement.getInput("Titulo", "titulo", "Titulo", "menu-titulo", BOBHtmlInputType.text, true, "", ""));
		tInputs.add(BOBHtmlElement.getInput("Descripcion", "descripcion", "Descripcion", "menu-descripcion", BOBHtmlInputType.text, true, "", ""));
		tInputs.add(BOBHtmlElement.getInput("Icono", "icono", "Icono", "menu-icono", BOBHtmlInputType.text, true, "", ""));
		tInputs.add(BOBHtmlElement.getInput("Orden", "orden", "Orden", "menu-orden", BOBHtmlInputType.text, true, "", ""));
		tInputs.add(BOBHtmlElement.getInput("Estado", "estado", "Estado", "menu-estado", BOBHtmlInputType.text, true, "", ""));
		
		crud.setfInputs(tInputs);
		crud.setRequest(request);
		crud.setDescription("cualquier cosa");
		crud.setIdHTML("FormHtml");
		
		model.addAttribute("BOB_LIST", crud.OuputHtmlForms());
	}
		
	private void ListarMenus() {
		List<BOBHtmlElement> theader = new ArrayList<>();
		theader.add(BOBHtmlElement.getTh("Id", true, "idMenu", "centrar", "5%"));
		theader.add(BOBHtmlElement.getTh("Padre", false, "idPadre", "centrar", "5%"));
		theader.add(BOBHtmlElement.getTh("Nombre", false, "nombre", "izquierda", "10%"));
		theader.add(BOBHtmlElement.getTh("Titulo", false, "titulo", "izquierda", "10%"));
		theader.add(BOBHtmlElement.getTh("Descripcion", false, "descripcion", "izquierda", "50%"));
		theader.add(BOBHtmlElement.getTh("Icono", false, "icono", "izquierda", "10%"));
		theader.add(BOBHtmlElement.getTh("Orden", false, "orden", "centrar", "5%"));
		theader.add(BOBHtmlElement.getTh("Estado", false, "estado", "centrar", "5%"));
		crud.setRequest(request);
		crud.setTheader(theader);
		Set<BOBCRUD> crudlist = new HashSet();
		crudlist.add(BOBCRUD.create);
		crudlist.add(BOBCRUD.delete);
		crudlist.add(BOBCRUD.retrieve);
		crudlist.add(BOBCRUD.update);
		crud.setCrud(crudlist);
		crud.setNunRegistro(IndexAdminTablasDAO.findByNombre("menus").getFilas());
		crud.setDescription("cualquier cosa");
		crud.setExportData(true);
		crud.setFieldList(menusDao.findAll());
		crud.setIdHTML("tablaAdmin");
		crud.setImportData(true);
		
		model.addAttribute("BOB_LIST", crud.OuputHtml());
	}

	@Override
	public Boolean instalar(List hooks) {return null;}

	@Override
	public Boolean desinsatalar(List hooks) {return null;}
	
}
