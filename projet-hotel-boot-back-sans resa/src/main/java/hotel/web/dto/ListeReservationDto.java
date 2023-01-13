package hotel.web.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import hotel.model.TypeLogement;

public class ListeReservationDto {
	private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDebut_resa;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateFin_resa;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate naissance;
	private Integer nombrePassager;

	public ListeReservationDto() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateDebut_resa() {
		return dateDebut_resa;
	}

	public void setDateDebut_resa(LocalDate dateDebut_resa) {
		this.dateDebut_resa = dateDebut_resa;
	}

	public LocalDate getDateFin_resa() {
		return dateFin_resa;
	}

	public void setDateFin_resa(LocalDate dateFin_resa) {
		this.dateFin_resa = dateFin_resa;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephome) {
		this.telephone = telephome;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	public Integer getNombrePassager() {
		return nombrePassager;
	}

	public void setNombrePassager(Integer nombrePassager) {
		this.nombrePassager = nombrePassager;
	}


	
	
	
}


