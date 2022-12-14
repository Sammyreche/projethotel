package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.stereotype.Component;

@Entity
@Component
@PrimaryKeyJoinColumn(name = "id_personnel")
public class Personnel extends Compte {
	

	private String nom;
	private String prenom;
	
	public Personnel() {
		
		
		
	}
	
	
	
	

}
