package core.component;

import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class BOBHtmlFilter {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){return sessionFactory.getCurrentSession();}
	private static BOBHtmlFilter instance;
	
	private BOBHtmlFilter (){}
	
	public static BOBHtmlFilter getInstance() {
		return instance;
	}
	
	public List findByCriteria(Object filter) {

		
		String hql = "from\n\tclassName\nwhere\n\tclassProperties";
		for (Field field : filter.getClass().getDeclaredFields()){
			String nullValue = "null";
			if (field.getType() == int.class){
				nullValue = "0";
			}
			hql = hql.replace("classProperties", "(:"+field.getName()+"="+nullValue+" or "+field.getName()+"="+":"+field.getName()+")\n\tand classProperties"); //"+":"+field.getName()+"==null
		}
		hql = hql.replace("className", filter.getClass().getSimpleName());
		hql = hql.replace("\n\tand classProperties", "");
		
		Query q = getSession().createQuery(hql);
		q.setProperties(filter); // fooBean has getName() and getSize()
		
		return q.list();

	}

}
