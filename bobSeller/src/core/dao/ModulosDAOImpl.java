package core.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import core.pojo.Modulos;

@Repository
@Transactional
public class ModulosDAOImpl implements ModulosDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){return sessionFactory.getCurrentSession();}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Modulos> findAll() {
		Criteria crit = getSession().createCriteria(Modulos.class);
		return crit.list();
	}

	@Override
	public Object getObject() {
		return new Modulos();
	}





}
