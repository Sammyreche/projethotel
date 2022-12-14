package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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
