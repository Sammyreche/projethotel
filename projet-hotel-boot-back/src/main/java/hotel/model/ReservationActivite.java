package hotel.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table (name = "activities")
public class ReservationActivite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "date")
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "passager")
	private Passager passager;
	
	@ManyToOne
	private Prestation prestation; 
	
	public ReservationActivite() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}
	
	

}
