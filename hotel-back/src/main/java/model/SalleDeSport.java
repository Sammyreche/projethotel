package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
@DiscriminatorValue("gym")
public class SalleDeSport extends Prestation {
	
	public SalleDeSport() {
		// TODO Auto-generated constructor stub
	}

}
