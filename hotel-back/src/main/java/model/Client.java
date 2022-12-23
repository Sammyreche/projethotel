package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.stereotype.Component;

@Entity
@Component
@PrimaryKeyJoinColumn(name = "id_client")
public class Client extends Compte{

	@Column(columnDefinition = "VARCHAR(35)")
	private String nom;
	@Column(columnDefinition = "VARCHAR(35)")
	private String prenom;
	@Column(columnDefinition = "VARCHAR(15)")
	private String telephone;
	@Column(columnDefinition = "VARCHAR(35)")
	private LocalDate naissance;
	@Embedded
	@OneToOne
	private Reservation resa;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Client(String nom, String prenom, String telephone, LocalDate naissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.naissance = naissance;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}
	
	
	
	
	
	

}
