package hotel.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table (name = "staff")
@PrimaryKeyJoinColumn(name = "id_personnel")
@DiscriminatorValue("personnel")
public class Personnel extends Compte {
	
	@Column(name = "name", columnDefinition = "VARCHAR(35)")
	@JsonView(views.ViewBase.class)
	private String nom;
	
	@Column(name = "firstname", columnDefinition = "VARCHAR(35)")
	@JsonView(views.ViewBase.class)
	private String prenom;
	@JsonView(views.ViewBase.class)
	private String fonction;
	
	@JsonView(views.ViewBase.class)
	private Integer salaire;
	
	public Personnel() {
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


	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public Integer getSalaire() {
		return salaire;
	}

	public void setSalaire(Integer salaire) {
		this.salaire = salaire;
	}

	

}
