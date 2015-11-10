package core.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import core.component.ApplicationContextHolder;
import core.pojo.mapeo_hook;
import core.service.MapeoHookService;

@Controller
public class HookController{
	
	//Creamos una variable de tipo MapeoHookService que nos permita consultar los modulos por hook
	@Autowired
	private MapeoHookService mapeohookService;
	
	private String baseUrlProyect = "~/bobSeller/";
	private String baseUrlAdmin = "bobSeller/admin/";
	private String mUrl = "modulos/";
		
	//Implementamos la funcion que nos permite acceder a los metodos implementados por los modulos
	public void FuncionesHook(Model model, String vista, String modulo, HttpServletRequest request) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{ 
		
		//Consultamos los modulos registrados para los hook disponibles para esta vista
		List<mapeo_hook> hooks = mapeohookService.findVista(vista);
		
		System.out.println("Construllendo los hook ");
		
		//Recorremos los hook que estan inscritos a la vista
		for (mapeo_hook hook:hooks) {
			if(0 != "HOOKADMIN".compareTo(hook.getDisplay())) llamadoClaseModulo(hook,model,vista,modulo,request);
			if(0 == modulo.compareTo(hook.getModuloNombre())) llamadoClaseModulo(hook,model,vista,modulo,request);
		}
		
		model.addAttribute("baseUrlProyect",baseUrlProyect);
		model.addAttribute("baseUrlAdmin",baseUrlAdmin);
		
	}
	
	//Implementamos la funcion que nos permite acceder a los metodos implementados por los modulos
	public void llamadoClaseModulo(mapeo_hook hook, Model model, String vista, String modulo, HttpServletRequest request) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{ 
		
		//Objeto tipo mapa para construir los modulos de cada Hook
		Map<String, ArrayList<Map>> hookList = new HashMap<>();
		
		//Array que contiene las rutas de los modulos por hook
		String ModuloHook; 
		
		try {
			System.out.println("entre a procesar hook");
			//Array temporal para construir todas las rutas de los modulos
			ArrayList<Map> temp = new ArrayList<Map>();
		
			//Array temporal para construir los datos del modulo a insertar
			Map<String,String> tempModulo = new HashMap();
						
			//Instanciamos la clase del modulo 
			ModulosController claseModulo = (ModulosController) ApplicationContextHolder.getContext().getBean(hook.getModuloClase());
			
			if(hookList.get(hook.getDisplay()) != null) temp = hookList.get(hook.getDisplay());
			
			//Buscamos el modulo url para el Modulo a inyectar en este  hook
			ModuloHook = mUrl+hook.getModuloPaquete()+"/"+claseModulo.getHook(hook.getDisplay(),model,request);
	
			tempModulo.put("urlModulo", ModuloHook);
			tempModulo.put("nombreModulo", hook.getModuloNombre());
			tempModulo.put("idModulo", Integer.toString(hook.getIdModulos()));
			tempModulo.put("idHook", Integer.toString(hook.getIdHook()));
			
			//anexamos el hook y modulo a la variable que se enviara a la vista 
			temp.add(tempModulo);
			
			hookList.put(hook.getDisplay(),temp);
			model.addAttribute(hook.getDisplay(),temp);
			
		} catch (Exception e) {
			model.addAttribute("HOOKERROR","Error en la carga del modulo: '"+hook.getModuloNombre()+"' posiblemente la clase '"+hook.getModuloClase()+ "', No esta siendo localizada por BobSeller.");
		}
		
	}

}
