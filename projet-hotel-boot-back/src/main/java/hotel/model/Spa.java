package hotel.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@DiscriminatorValue("spa")
public class Spa extends Prestation {
	
	 
	public Spa() {
		// TODO Auto-generated constructor stub
	}

}
