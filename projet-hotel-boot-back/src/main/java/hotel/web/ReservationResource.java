package hotel.web;

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
import hotel.model.Reservation;
import hotel.model.views;



@RestController
@RequestMapping("/reservations")
@CrossOrigin("*")
public class ReservationResource {

	@Autowired
	private IDAOReservation daoReservation;

	@GetMapping("")
	public List<Reservation> findall() {
		List<Reservation> reservations = daoReservation.findAll();

		return reservations;
	}

	//aurevoir
//	@GetMapping("/{id}")
//	public Reservation findById(@PathVariable Integer id) {
//		Optional<Reservation> optReservation = daoReservation.findById(id);
//
//		if (optReservation.isEmpty()) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		}
//
//		return optReservation.get();
//	}
	
	@GetMapping("/{id}/detail")
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
