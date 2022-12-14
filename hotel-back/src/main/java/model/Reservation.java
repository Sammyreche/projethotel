package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
	
	private Client clientPrincipal;
	private List<Passager> clients = new ArrayList();
	private Hotel hotel;
	private LocalDate date;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Client getClientPrincipal() {
		return clientPrincipal;
	}

	public void setClientPrincipal(Client clientPrincipal) {
		this.clientPrincipal = clientPrincipal;
	}

	public List<Passager> getClients() {
		return clients;
	}

	public void setClients(List<Passager> clients) {
		this.clients = clients;
	}
	

}
