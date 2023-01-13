package hotel.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
@Entity
@Table (name = "passenger")
public class Passager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(views.ViewBase.class)
	private Integer id;
	
	@Column(name = "name", columnDefinition = "VARCHAR(35)")
	@JsonView(views.ViewBase.class)
	private String nom;
	
	@Column(name = "firstname", columnDefinition = "VARCHAR(35)")
	@JsonView(views.ViewBase.class)
	private String prenom;
	
	@JoinColumn(name = "room_id")
	@OneToOne  
	private Chambre chambre;
	
	@Column(name = "birthdate")
	private LocalDate naissance;
	
	@ManyToOne (cascade = CascadeType.REFRESH)
	@JoinColumn(name ="resa")
	@JsonView(Views.ViewBase.class)
	private Reservation resa;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	private ReservationActivite resactivite;
	
	public Passager() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	public Reservation getResa() {
		return resa;
	}

	public void setResa(Reservation resa) {
		this.resa = resa;
	}

	public ReservationActivite getResactivite() {
		return resactivite;
	}

	public void setResactivite(ReservationActivite resactivite) {
		this.resactivite = resactivite;
	}

	@Override
	public String toString() {
		return "Passager [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", chambre=" + chambre + ", naissance="
				+ naissance + " resactivite=" + resactivite + "]";
	}


	
	

}
