package model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	
	private Admin admin;
	private List<Personnel> personnels = new ArrayList();
	private List<Reservation> reservations =new ArrayList();
	
	public Hotel() {
		// TODO Auto-generated constructor stub
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Personnel> getPersonnels() {
		return personnels;
	}

	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}
	
	

}
