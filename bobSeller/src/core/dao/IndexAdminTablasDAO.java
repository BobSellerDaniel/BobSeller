package core.dao;

import core.pojo.IndexAdminTablas;

public interface IndexAdminTablasDAO { 
	
	public IndexAdminTablas findByNombre(String nombreTabla);

}
