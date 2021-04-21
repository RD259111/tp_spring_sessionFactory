package banque.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import banque.persistence.dao.CompteDaoImpl;
import banque.persistence.entities.Compte;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {
	
	@Autowired
	private CompteDaoImpl compteDao;

	public void add(Compte compte) {
		compteDao.add(compte);
		
	}

	public List<Compte> findAll() {
		return compteDao.findAll();
	}

	public void update(Compte compte) {
		compteDao.update(compte);
		
	}

	public void delete(Compte compte) {
		compteDao.delete(compte);
	}

	public Compte findById(Serializable id) {
		return compteDao.findById(id);
	}

}