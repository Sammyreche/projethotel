package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.stereotype.Component;

@Entity
@Component
@PrimaryKeyJoinColumn(name = "id_admin")
public class Admin extends Compte {
	
	
	
	public Admin() {}
	
	

}
