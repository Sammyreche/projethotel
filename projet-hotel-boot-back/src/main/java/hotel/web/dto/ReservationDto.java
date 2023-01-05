package hotel.web.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import hotel.model.TypeLogement;

public class ReservationDto {
	private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDebut_resa;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateFin_resa;
	private List<ReservationActivitePassagerDTO> passagers = new ArrayList<>();
	private String typeLogement;

	public ReservationDto() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateDebut_resa() {
		return dateDebut_resa;
	}

	public void setDateDebut_resa(LocalDate dateDebut_resa) {
		this.dateDebut_resa = dateDebut_resa;
	}

	public LocalDate getDateFin_resa() {
		return dateFin_resa;
	}

	public void setDateFin_resa(LocalDate dateFin_resa) {
		this.dateFin_resa = dateFin_resa;
	}

	public List<ReservationActivitePassagerDTO> getPassagers() {
		return passagers;
	}

	public void setPassagers(List<ReservationActivitePassagerDTO> passagers) {
		this.passagers = passagers;
	}

	public String getTypeLogement() {
		return typeLogement;
	}

	public void setTypeLogement(String typeLogement) {
		this.typeLogement = typeLogement;
	}
	
}


