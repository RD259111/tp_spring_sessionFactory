package banque.persistence.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import banque.persistence.entities.Client;

@Repository
public class ClientDaoImpl implements ClientDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void add(Client client) {
		sessionFactory.getCurrentSession().save(client);
	}

	public List<Client> findAll() {
		List<Client> listClients = sessionFactory.getCurrentSession().createQuery("from Client").list();
		return listClients;
	}

	public void update(Client client) {
		sessionFactory.getCurrentSession().update(client);
	}

	public void delete(Client client) {
		sessionFactory.getCurrentSession().delete(client);
	}

	public Client findById(Serializable id) {
		return sessionFactory.getCurrentSession().get(Client.class, (BigDecimal) id);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}