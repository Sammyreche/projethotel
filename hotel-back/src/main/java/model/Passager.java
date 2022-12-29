package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table (name = "passenger")
public class Passager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", columnDefinition = "VARCHAR(35)", nullable = false)
	private String nom;
	
	@Column(name = "firstname", columnDefinition = "VARCHAR(35)", nullable = false)
	private String prenom;
	
	@Column(name = "room", columnDefinition = "VARCHAR(35)", nullable = false)
	private Chambre chambre;
	
	@Column(name = "birthdate", nullable = false)
	private LocalDate naissance;
	
	@ManyToOne
	@JoinColumn(name ="resa")
	private Reservation resa;
	
	@OneToMany(mappedBy = "passenger")
	private List<ReservationActivite> resactivite = new ArrayList();
	
	public Passager() {
		// TODO Auto-generated constructor stub
	}
	
	

}
