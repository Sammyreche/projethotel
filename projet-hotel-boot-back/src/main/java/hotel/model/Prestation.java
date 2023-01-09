package hotel.model;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import hotel.model.Views;









@Entity
@Table (name = "prestation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
<<<<<<< Updated upstream
@DiscriminatorColumn(name="Prestation",columnDefinition = "ENUM('restaurant','spa','gym')")
=======
@DiscriminatorColumn(name="type_prestation",columnDefinition = "ENUM('restaurant','spa','gym')")
>>>>>>> Stashed changes
public abstract class Prestation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
<<<<<<< Updated upstream
	
	@OneToMany (mappedBy = "prestation",orphanRemoval = false,cascade = CascadeType.REMOVE)
=======
	//@JsonView(Views.ViewBase.class)
	@OneToMany (mappedBy = "prestation")
>>>>>>> Stashed changes
	private List <ReservationActivite> resaActivite;
	
	
	@Column(name="price",columnDefinition = "DECIMAL(6,2)")
	@JsonView(Views.ViewBase.class)
	private Double prix;
	
	private int nombre;
	
	@Enumerated(EnumType.STRING) //ça sert à quoi ?
	@Column(name="type_prestation",columnDefinition = "ENUM('restaurant','spa','gym')")
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

	public List<ReservationActivite> getResaActivite() {
		return resaActivite;
	}

	public void setResaActivite(List<ReservationActivite> resaActivite) {
		this.resaActivite = resaActivite;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

<<<<<<< Updated upstream
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

=======
>>>>>>> Stashed changes
	
	
}
