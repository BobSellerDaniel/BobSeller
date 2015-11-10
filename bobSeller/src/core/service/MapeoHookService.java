package core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.MapeoHookDAO;
import core.pojo.mapeo_hook;

@Service
public class MapeoHookService  {
	
	@Autowired
	private MapeoHookDAO mapeoHookDao;
	
	public List<mapeo_hook> findAll() {
		return mapeoHookDao.findAll();
	}

	public List<mapeo_hook> findVista(String vista) {
		return mapeoHookDao.findVista(vista);
	}
	

}
