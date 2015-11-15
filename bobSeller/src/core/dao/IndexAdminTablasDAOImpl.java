package core.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import core.pojo.IndexAdminTablas;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class IndexAdminTablasDAOImpl implements IndexAdminTablasDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){return sessionFactory.getCurrentSession();}
	
	@Override
	public IndexAdminTablas findByNombre(String nombreTabla) {
		Criteria crit = getSession().createCriteria(IndexAdminTablas.class);
		crit.add(Restrictions.eq("nombreTabla", nombreTabla));
		return (IndexAdminTablas) crit.uniqueResult();
	}
	
}
