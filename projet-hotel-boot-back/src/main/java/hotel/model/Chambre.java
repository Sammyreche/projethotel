package hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
//TO-DO ajouté un booléen disponibilité -- date de résa ?

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table (name = "room")
public class Chambre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@Enumerated(EnumType.STRING) //ça sert à quoi ?
	@JsonView(Views.ViewBase.class)
	@Column(name="typeChambre",nullable = false,columnDefinition = "ENUM('chambresimple','suite','suitepresidentielle')")
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
	
	


}
