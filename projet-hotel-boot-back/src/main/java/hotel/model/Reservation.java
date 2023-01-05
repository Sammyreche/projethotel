package hotel.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table (name = "reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name ="mainClient")
	private Client clientPrincipal;
	
	@OneToMany (mappedBy = "resa")
	private List<Passager> passagers = new ArrayList();
	
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}


	

}
