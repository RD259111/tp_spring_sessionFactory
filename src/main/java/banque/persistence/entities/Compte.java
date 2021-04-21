package banque.persistence.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE")
public class Compte {

	private BigDecimal id;
	private String nomCompte;
	private Client client = new Client();

	public Compte() {
	}

	public Compte(BigDecimal id) {
		this.id = id;
	}
	
	public Compte(BigDecimal id, String nomCompte, Client client) {
		this.id = id;
		this.nomCompte = nomCompte;
		this.client = client;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPTE_SEQ")
	@SequenceGenerator(name="COMPTE_SEQ", sequenceName = "COMPTE_SEQ", allocationSize = 1)
	@Column(name = "IDCOMPTE", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return id;
	}	

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "NOMCOMPTE", length = 1016)
	public String getNomCompte() {
		return nomCompte;
	}

	public void setNomCompte(String nomCompte) {
		this.nomCompte = nomCompte;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCLIENT")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}