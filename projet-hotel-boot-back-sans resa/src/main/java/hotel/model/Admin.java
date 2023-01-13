package hotel.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table (name = "admin")
@PrimaryKeyJoinColumn(name = "id_admin")
@DiscriminatorValue("admin")
public class Admin extends Compte {
	@Column(name = "name", columnDefinition = "VARCHAR(35)")
	@JsonView(views.ViewBase.class)
	private String nom;
	
	@Column(name = "firstname", columnDefinition = "VARCHAR(35)")
	@JsonView(views.ViewBase.class)
	private String prenom;
	
	
	
	public Admin() {}
	
	

}
