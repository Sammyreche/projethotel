package model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chambre {

	private TypeLogement type;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public Chambre() {
		// TODO Auto-generated constructor stub
	}

	public Chambre(TypeLogement type) {
		super();
		this.type = type;
	}

	public TypeLogement getType() {
		return type;
	}

	public void setType(TypeLogement type) {
		this.type = type;
	}
	
	
	
	

}
