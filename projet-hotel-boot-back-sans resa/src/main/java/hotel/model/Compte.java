package hotel.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
//@Table(name="compte", uniqueConstraints=@UniqueConstraint(columnNames = { "login","password"}) ) 
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="type_compte",columnDefinition = "ENUM('admin','personnel','client')")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "className")
public abstract class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(views.ViewBase.class)
	protected Integer id;
	
	@Column(name = "login", length= 50, nullable = false) 
	protected String login;
	
	@Column(name = "password", length= 20, nullable = false)
	protected String password;
	
	
	public Compte() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	


}
