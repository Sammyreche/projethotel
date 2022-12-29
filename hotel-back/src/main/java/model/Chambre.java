package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table (name = "room")
@Component
public class Chambre {

	@Enumerated(EnumType.STRING)
	@Column(name="typeChambre",nullable = false,columnDefinition = "ENUM('chambresimple','suite','suitepresidentielle')")
	private TypeLogement type;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public Chambre() {}


}
