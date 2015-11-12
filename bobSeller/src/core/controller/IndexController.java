package core.controller;
import java.lang.reflect.InvocationTargetException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("resultado")
public class IndexController extends HookController{
	
	private String mUrl = "views/";
	
	@RequestMapping("/")
	public String showIndex(Model model, Principal principal, HttpServletRequest request ) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		if(principal != null){
			super.FuncionesHook(model,"/admin","",request);
			return mUrl+"admin";
		}
		else{
			super.FuncionesHook(model,"/","",request);
			return mUrl+"index";
		}
	}
	
	@RequestMapping(value={"/admin", "/admin/"})
	public String adminHome(Model model, HttpServletRequest request) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
		super.FuncionesHook(model,"/admin","",request);
		return mUrl+"admin";
	}
	
	@RequestMapping(value="/admin/{modulo}.html", method = {RequestMethod.GET,RequestMethod.POST})
	public String admin(Model model, @PathVariable("modulo") String modulo, HttpServletRequest request) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
		//System.out.println("Variables post capturadas: "+request.getParameter("VARLO"));
		System.out.println("helloss");
		System.out.println("una aduciion de daniel ");
		super.FuncionesHook(model,"/admin",modulo,request);
		return mUrl+"admin";
	}
	
	@RequestMapping("/about")
	public String showAbout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "about";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "/";
	}
	
}