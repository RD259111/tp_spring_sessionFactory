package banque.persistence.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import banque.persistence.entities.Compte;

@Repository
public class CompteDaoImpl implements CompteDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void add(Compte compte) {
		sessionFactory.getCurrentSession().save(compte);
	}

	public List<Compte> findAll() {
		List<Compte> listComptes = sessionFactory.getCurrentSession().createQuery("from Compte").list();
		return listComptes;
	}

	public void update(Compte compte) {
		sessionFactory.getCurrentSession().update(compte);
		
	}

	public void delete(Compte compte) {
		sessionFactory.getCurrentSession().delete(compte);
		
	}

	public Compte findById(Serializable id) {
		return sessionFactory.getCurrentSession().get(Compte.class, (BigDecimal) id);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}