package banque.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import banque.persistence.dao.ClientDaoImpl;
import banque.persistence.entities.Client;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDaoImpl clientDao;
	
	public void add(Client client) {
		clientDao.add(client);
		
	}

	public List<Client> findAll() {
		return clientDao.findAll();
	}

	public void update(Client client) {
		clientDao.update(client);
		
	}

	public void delete(Client client) {
		clientDao.delete(client);
		
	}

	public Client findById(Serializable id) {
		return clientDao.findById(id);
	}

}