package hotel.model;

import java.util.List;
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

@Entity
@Table (name = "services")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Prestation",columnDefinition = "ENUM('restaurant','spa','gym')")
public abstract class Prestation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany (mappedBy = "prestation")
	private List <ReservationActivite> resaActivite;
	
	@Column(name="price",columnDefinition = "DECIMAL(6,2)")
	private Double prix;
	
	private int nombre;
	
	@Enumerated(EnumType.STRING) //ça sert à quoi ?
	@Column(name="type_prestation",nullable = false,columnDefinition = "ENUM('restaurant','spa','gym')")
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

	
	
}
