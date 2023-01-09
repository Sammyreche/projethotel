package hotel.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//TO-DO ajouté un booléen disponibilité -- date de résa ?

@Entity
@Table (name = "room")
public class Chambre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany (cascade = CascadeType.REMOVE,mappedBy = "chambre")
	//@OneToOne(orphanRemoval = false, cascade = CascadeType.REFRESH)
	private List<Passager> passagers;
	
	@Enumerated(EnumType.STRING) //ça sert à quoi ?
	@Column(name="typeChambre",columnDefinition = "ENUM('chambresimple','suite','suitepresidentielle')")
	private TypeLogement type;
	

	
	public Chambre() {}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public TypeLogement getType() {
		return type;
	}



	public void setType(TypeLogement type) {
		this.type = type;
	}



	public List<Passager> getPassagers() {
		return passagers;
	}



	public void setPassager(List<Passager> passager) {
		this.passagers = passager;
	}
	
	


}
