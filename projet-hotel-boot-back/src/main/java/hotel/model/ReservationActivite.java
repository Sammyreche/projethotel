package hotel.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table (name = "reservation_activities")
public class ReservationActivite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@Column(name = "date")
	@JsonView(Views.ViewBase.class)
	private LocalDate date;
	
	@OneToOne (orphanRemoval = true ,cascade = CascadeType.REFRESH)
	@JoinColumn(name = "passager")
	@JsonView(Views.ViewBase.class)
	private Passager passager;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
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
