package model;

import java.time.LocalDate;

public abstract class Prestation {
	
	private ReservationActive resaActive;
	private LocalDate dateDeResa;
	
	public Prestation() {
		// TODO Auto-generated constructor stub
	}

	public ReservationActive getResaActive() {
		return resaActive;
	}

	public void setResaActive(ReservationActive resaActive) {
		this.resaActive = resaActive;
	}

	public LocalDate getDateDeResa() {
		return dateDeResa;
	}

	public void setDateDeResa(LocalDate dateDeResa) {
		this.dateDeResa = dateDeResa;
	}
	
	

}
