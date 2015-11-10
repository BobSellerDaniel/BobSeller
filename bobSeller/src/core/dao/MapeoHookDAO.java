package core.dao;

import java.util.List;

import core.pojo.mapeo_hook;

public interface MapeoHookDAO {

	public List<mapeo_hook> findAll();
	public List<mapeo_hook> findVista(String vista);
	
}
