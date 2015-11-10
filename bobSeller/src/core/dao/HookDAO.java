package core.dao;
import java.util.List;

import core.pojo.Hook;

public interface HookDAO {
	
	public Hook findByNombre(String hook);
	public List<Hook> findAll();
	public List<Object> HookModulos();
	
}
