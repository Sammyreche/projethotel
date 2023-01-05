package hotel.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table (name = "client")
@PrimaryKeyJoinColumn(name = "id_client")
public class Client extends Compte{

	@Column(name = "name", columnDefinition = "VARCHAR(35)", nullable = false)
	@JsonView(views.ViewBase.class)
	private String nom;
	
	@Column(name = "firstname", columnDefinition = "VARCHAR(35)", nullable = false)
	@JsonView(views.ViewBase.class)
	private String prenom;
	
	@Column(name = "email", columnDefinition = "VARCHAR(50)", nullable = false)
	@JsonView(views.ViewBase.class)
	private String mail;
	
	@Column(name = "tel", columnDefinition = "VARCHAR(15)", nullable = false)
	@JsonView(views.ViewBase.class)
	private String telephone;
	
	@Column(name = "birthdate", nullable = false)
	@JsonView(views.ViewBase.class)
	private LocalDate naissance;
	
	@OneToMany (mappedBy = "clientPrincipal")
	private List <Reservation> resa;
	
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
