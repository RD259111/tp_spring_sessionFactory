package banque.persistence.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {

	private BigDecimal id;
	private String nom;
	private Set<Compte> comptes = new HashSet<Compte>(0);
	
	public Client() {
	}

	public Client(BigDecimal id) {
		this.id = id;
	}

	public Client(BigDecimal id, String nom, Set<Compte> comptes) {
		this.id = id;
		this.nom = nom;
		this.comptes = comptes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_SEQ")
	@SequenceGenerator(name="CLIENT_SEQ", sequenceName = "CLIENT_SEQ", allocationSize = 1)
	@Column(name = "IDCLIENT", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "NOMCLIENT", length = 1016)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	
}