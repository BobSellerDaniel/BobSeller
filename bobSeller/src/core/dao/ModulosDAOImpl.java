package core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		return (List<Modulos>) crit.list();
	}
	
}
