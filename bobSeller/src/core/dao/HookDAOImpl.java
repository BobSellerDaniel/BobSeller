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

import core.pojo.Hook;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class HookDAOImpl implements HookDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session getSession(){return sessionFactory.getCurrentSession();}
	
	@Override
	public List<Hook> findAll() {
		Query query = getSession().createQuery("from Hook");
		return query.list();
	}

	@Override
	public Hook findByNombre(String hook) {
		Criteria crit = getSession().createCriteria(Hook.class).add(Restrictions.eq("hook", hook));
		return (Hook) crit.uniqueResult();
	}

	@Override
	public List<Object> HookModulos() {
		Query query = getSession().createQuery("select distinct c from Campaign c join fetch c.subcampaigns s join fetch s.budgets");
		List<Object> campaigns = query.list();
		return campaigns;
	}
}
