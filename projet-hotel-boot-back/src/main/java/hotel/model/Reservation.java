package hotel.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table (name = "reservation")

public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(views.ViewBase.class)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name ="mainClient")
	@JsonView(views.ViewResa.class)
	private Client clientPrincipal;
	
	@OneToMany (mappedBy = "resa", orphanRemoval = true, cascade = CascadeType.REFRESH)
	@JsonView(views.ViewResa.class)
	private List<Passager> passagers = new ArrayList<>();
	
	@Column(name = "date_Debut")
	@JsonView(views.ViewBase.class)
	private LocalDate dateDebut;
	
	@Column(name = "date_fin")
	@JsonView(views.ViewBase.class)
	private LocalDate dateFin;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClientPrincipal() {
		return clientPrincipal;
	}

	public void setClientPrincipal(Client clientPrincipal) {
		this.clientPrincipal = clientPrincipal;
	}

	public List<Passager> getPassagers() {
		return passagers;
	}

	public void setPassagers(List<Passager> passagers) {
		this.passagers = passagers;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Reservation(Integer id, Client clientPrincipal, List<Passager> passagers, LocalDate dateDebut,
			LocalDate dateFin) {
		this.id = id;
		this.clientPrincipal = clientPrincipal;
		this.passagers = passagers;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", clientPrincipal=" + clientPrincipal + ", passagers=" + passagers
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}



	
	

}
