package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_presta",columnDefinition = "ENUM('resto','spa','salledesport')")
public abstract class Prestation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany
	private List<ReservationActivite> resaActive = new ArrayList();
	private Double prix;
	
	public Prestation() {
		// TODO Auto-generated constructor stub
	}

	
	
}
