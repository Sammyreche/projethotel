package hotel.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "prestation")
public class Prestation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	
	@Column(name="price",columnDefinition = "DECIMAL(6,2)")
	private Double prix;
	
	private int nombre;
	
	@Column(name = "date_prestation")
	private LocalDate date;
	
	@Enumerated(EnumType.STRING) 
	@Column(name="type_prestation",columnDefinition = "ENUM('restaurant','spa','salledesport')")
	private TypeActivite typeActivite;
	
	public Prestation() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public TypeActivite getTypeActivite() {
		return typeActivite;
	}

	public void setTypeActivite(TypeActivite typeActivite) {
		this.typeActivite = typeActivite;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	
}
