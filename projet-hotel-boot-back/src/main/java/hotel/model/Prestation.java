package hotel.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
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
@DiscriminatorColumn(name="type_prestation",columnDefinition = "ENUM('restautant','spa','gym')")
public abstract class Prestation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany (mappedBy = "prestation")
	private List <ReservationActivite> resaActivite;
	
	@Column(name="price",columnDefinition = "DECIMAL(6,2)")
	private Double prix;
	
	public Prestation() {
		// TODO Auto-generated constructor stub
	}

	
	
}
