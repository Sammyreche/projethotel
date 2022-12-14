package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationActivite {

	private LocalDate date;
	private Passager passager;
	private List<Prestation> prestation = new ArrayList();
	
	public ReservationActivite() {
		// TODO Auto-generated constructor stub
	}

	public List<Prestation> getPrestation() {
		return prestation;
	}

	public void setPrestation(List<Prestation> prestation) {
		this.prestation = prestation;
	}
	
}
