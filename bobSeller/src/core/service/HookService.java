package core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.HookDAO;
import core.pojo.Hook;

@Service
public class HookService {
	
	@Autowired
	private HookDAO hookDao;
	
	public List<Hook> findAll() {
		return hookDao.findAll();
	}
	
}
