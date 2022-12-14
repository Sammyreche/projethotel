package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Passager {
	
	private String nom;
	private String prenom;
	private Chambre chambre;
	private LocalDate naissance;
	private Reservation resa;
	private List<ReservationActivite> resas = new ArrayList();
	
	public Passager() {
		// TODO Auto-generated constructor stub
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public List<ReservationActivite> getResas() {
		return resas;
	}

	public void setResas(List<ReservationActivite> resas) {
		this.resas = resas;
	}
	
	

}
