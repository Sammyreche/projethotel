package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table (name = "staff")
@Component
@PrimaryKeyJoinColumn(name = "id_personnel")
public class Personnel extends Compte {
	
	@Column(name = "name", columnDefinition = "VARCHAR(35)", nullable = false)
	private String nom;
	
	@Column(name = "firstname", columnDefinition = "VARCHAR(35)", nullable = false)
	private String prenom;
	
	public Personnel() {
		
		
		
	}
	
	
	
	

}
