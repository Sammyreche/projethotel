package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
@DiscriminatorValue("restaurant")
public class Resto extends Prestation{
	
	public Resto() {
		// TODO Auto-generated constructor stub
	}

}
