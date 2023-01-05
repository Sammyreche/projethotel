package hotel.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import hotel.dao.IDAOReservation;
import hotel.model.Passager;
import hotel.model.Reservation;
import hotel.model.views;
import hotel.web.dto.ReservationActivitePassagerDTO;
import hotel.web.dto.ReservationDto;



@RestController
@RequestMapping("/reservations")
@CrossOrigin("*")
public class ReservationResource {

	@Autowired
	private IDAOReservation daoReservation;

	@GetMapping("")
	public List<ReservationDto> findall() {
		
		List<ReservationDto>  reservationDto = new ArrayList<>();

	System.out.println(	daoReservation.findAll().size());
		for (int i = 1; i <= daoReservation.findAll().size(); i++) {
			reservationDto.add(findById(i));
		}

		return reservationDto;
	}

	//aurevoir
	@GetMapping("/{id}/detail")
	public ReservationDto findById(@PathVariable Integer id) {
		ReservationDto reservationDto = new ReservationDto();
		
		Reservation reservation = daoReservation.findById(id).get();
		for (Passager passager : reservation.getPassagers()) {
			ReservationActivitePassagerDTO activitePassagerDTO = new ReservationActivitePassagerDTO();
			activitePassagerDTO.setId_passager(passager.getId());
			activitePassagerDTO.setDate(passager.getResactivite().getDate());
			activitePassagerDTO.setNom_passager(passager.getNom());
			activitePassagerDTO.setPrenom_passager(passager.getPrenom());
			activitePassagerDTO.setNom_passager(passager.getNom());
			activitePassagerDTO.setNom_passager(passager.getNom());
			if (!(passager.getResactivite().getPrestation().getTypeActivite()==null)) {
				activitePassagerDTO.setNombre(passager.getResactivite() == null ? null :passager.getResactivite().getPrestation().getNombre());
				activitePassagerDTO.setTypeActivite(passager.getResactivite().getPrestation().getTypeActivite().toString());
			}
			reservationDto.getPassagers().add(activitePassagerDTO);
		}
		reservationDto.setId(reservation.getId());
		reservationDto.setDateDebut_resa(reservation.getDateDebut());
		reservationDto.setDateFin_resa(reservation.getDateFin());
		if (!reservation.getPassagers().isEmpty()) {
			reservationDto.setTypeLogement(reservation.getPassagers().get(0).getChambre().getType().toString());
		}else {
			reservationDto.setTypeLogement(null);
		}


		return reservationDto;
	}
	
	@GetMapping("/{id}")
	@JsonView(views.ViewResaPassager.class)
	public Reservation detailById(@PathVariable Integer id) {
		Optional<Reservation> optReservation = daoReservation.findById(id);

		if (optReservation.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optReservation.get();
	}

	@PostMapping("")
	public Reservation create(@Valid @RequestBody Reservation reservation, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le reservation n'a pu être créé");
		}

		reservation = daoReservation.save(reservation);

		return reservation;
	}

	@PutMapping("/{id}")
	public Reservation update(@PathVariable Integer id, @RequestBody Reservation reservation) {
		if (id != reservation.getId() || !daoReservation.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		reservation = daoReservation.save(reservation);

		return reservation;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoReservation.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoReservation.deleteById(id);
	}
}
