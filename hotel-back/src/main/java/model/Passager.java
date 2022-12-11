package model;

import java.util.ArrayList;
import java.util.List;

public class Passager {
	
	private Chambre chambre;
	private List<ReservationActive> resas = new ArrayList();
	
	public Passager() {
		// TODO Auto-generated constructor stub
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public List<ReservationActive> getResas() {
		return resas;
	}

	public void setResas(List<ReservationActive> resas) {
		this.resas = resas;
	}
	
	

}
