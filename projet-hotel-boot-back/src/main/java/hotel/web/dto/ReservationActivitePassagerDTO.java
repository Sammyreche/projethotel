package hotel.web.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import hotel.model.Chambre;

public class ReservationActivitePassagerDTO {

	private Integer id_passager;
	private String nom_passager;
	private String prenom_passager;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate naissance_passager;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private int nombre;
	private String typeActivite;
	
	
	public ReservationActivitePassagerDTO() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId_passager() {
		return id_passager;
	}
	public void setId_passager(Integer id_passager) {
		this.id_passager = id_passager;
	}
	public String getNom_passager() {
		return nom_passager;
	}
	public void setNom_passager(String nom_passager) {
		this.nom_passager = nom_passager;
	}
	public String getPrenom_passager() {
		return prenom_passager;
	}
	public void setPrenom_passager(String prenom_passager) {
		this.prenom_passager = prenom_passager;
	}
	public LocalDate getNaissance_passager() {
		return naissance_passager;
	}
	public void setNaissance_passager(LocalDate naissance_passager) {
		this.naissance_passager = naissance_passager;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public String getTypeActivite() {
		return typeActivite;
	}
	public void setTypeActivite(String typeActivite) {
		this.typeActivite = typeActivite;
	}
	
	
	
	
}
