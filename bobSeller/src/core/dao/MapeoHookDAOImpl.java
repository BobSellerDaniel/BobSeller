package core.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.pojo.mapeo_hook;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class MapeoHookDAOImpl implements MapeoHookDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){return sessionFactory.getCurrentSession();}
	
	@Override
	public List<mapeo_hook> findAll() {
		Query query = getSession().createQuery("from mapeo_hook");
		return query.list();
	}
	
	@Override
	public List<mapeo_hook> findVista(String vista) {
		//Query query = getSession().createQuery("from mapeo_hook m where m.url = "+vista);
		Criteria crit = getSession().createCriteria(mapeo_hook.class);
		crit.add(Restrictions.eq("vista", vista));
		return (List<mapeo_hook>) crit.list();
	}
	
}
