package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
@DiscriminatorValue("spa")
public class Spa extends Prestation {
	
	 
	public Spa() {
		// TODO Auto-generated constructor stub
	}

}
