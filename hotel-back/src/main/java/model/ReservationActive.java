package model;

import java.util.ArrayList;
import java.util.List;

public class ReservationActive {

	private List<Prestation> prestation = new ArrayList();
	
	public ReservationActive() {
		// TODO Auto-generated constructor stub
	}

	public List<Prestation> getPrestation() {
		return prestation;
	}

	public void setPrestation(List<Prestation> prestation) {
		this.prestation = prestation;
	}
	
}
