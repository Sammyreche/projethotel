package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Passager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private Chambre chambre;
	private LocalDate naissance;
	private Reservation resa;
	@OneToMany
	private List<ReservationActivite> resas = new ArrayList();
	
	public Passager() {
		// TODO Auto-generated constructor stub
	}
	
	

}
