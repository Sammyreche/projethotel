package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
@Embeddable
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	private Client clientPrincipal;
	@OneToMany
	private List<Passager> clients = new ArrayList();
	@ManyToOne
	private Hotel hotel;
	private LocalDate date;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}


	

}
