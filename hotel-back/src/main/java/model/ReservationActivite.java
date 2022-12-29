package model;

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
@Component
@Table (name = "activities")
public class ReservationActivite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "passager")
	private Passager passager;
	
	@OneToMany (mappedBy = "activities")
	private List<Prestation> prestation = new ArrayList();
	
	public ReservationActivite() {}

}
