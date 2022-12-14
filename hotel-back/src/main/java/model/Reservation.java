package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
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


	

}
