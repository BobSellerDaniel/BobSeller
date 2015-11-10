package core.dao;
import java.util.List;

import core.pojo.Menus;

public interface MenusDAO {
	
	public List<Menus> findAll(); 
	public Menus findByNombre(String hook);
	
}
