package core.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.pojo.Menus;

@Repository
@Transactional
public class MenusDAOImpl implements MenusDAO{
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	public Session getSession(){return sessionFactory.getCurrentSession();}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Menus> findAll() {
		Criteria crit = getSession().createCriteria(Menus.class).addOrder(Property.forName("orden").asc());
		return (List<Menus>) crit.list();
	}

	@Override
	public Menus findByNombre(String hook) {return null;}
	
}
