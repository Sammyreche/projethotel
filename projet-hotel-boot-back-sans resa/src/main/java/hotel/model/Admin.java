package hotel.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table (name = "admin")
@PrimaryKeyJoinColumn(name = "id_admin")
public class Admin extends Compte {
	
	
	
	public Admin() {}
	
	

}
