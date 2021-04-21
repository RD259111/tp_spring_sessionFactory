package banque.persistence.dao;

import java.io.Serializable;
import java.util.List;

import banque.persistence.entities.Compte;

public interface CompteDao {
	
	public void add(Compte compte);
	public List<Compte> findAll();
	public void update(Compte compte);
	public void delete(Compte compte);
	public Compte findById(Serializable id);
}