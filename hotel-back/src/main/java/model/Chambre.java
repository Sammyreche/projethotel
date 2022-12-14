package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Chambre {

	@Column(name="typeChambre",nullable = false,columnDefinition = "ENUM('chambresimple','suite','suitepresidentielle')")
	private TypeLogement type;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public Chambre() {}


}
