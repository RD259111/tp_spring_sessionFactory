package banque.services;

import java.io.Serializable;
import java.util.List;

import banque.persistence.entities.Client;

public interface ClientService {

	public void add(Client client);
	public List<Client> findAll();
	public void update(Client client);
	public void delete(Client client);
	public Client findById(Serializable id);

}