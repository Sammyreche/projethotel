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

import hotel.dao.IDAOReservationActivite;
import hotel.model.ReservationActivite;
import hotel.model.Views;



@RestController
@RequestMapping("/reservationActivites")
@CrossOrigin("*")
public class ReservationActiviteResource {
	@Autowired
	private IDAOReservationActivite daoReservationActivite;
	


	@GetMapping("")
	@JsonView(Views.ViewReservationActivite.class)
	public List<ReservationActivite> findAll() {
		List<ReservationActivite> reservationActivites = daoReservationActivite.findAll();

		return reservationActivites;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewReservationActivite.class)
	public ReservationActivite findById(@PathVariable Integer id) {
		Optional<ReservationActivite> optReservationActivite = daoReservationActivite.findById(id);

		if (optReservationActivite.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optReservationActivite.get();
	}
	
	@PostMapping("")
	@JsonView(Views.ViewReservationActivite.class)
	public ReservationActivite create(@Valid @RequestBody ReservationActivite reservationActivite, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le reservationActivite n'a pu être créé");
		}

		reservationActivite = daoReservationActivite.save(reservationActivite);

		return reservationActivite;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewReservationActivite.class)
	public ReservationActivite update(@PathVariable Integer id, @RequestBody ReservationActivite reservationActivite) {
		if (id != reservationActivite.getId() || !daoReservationActivite.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		reservationActivite = daoReservationActivite.save(reservationActivite);

		return reservationActivite;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoReservationActivite.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoReservationActivite.deleteById(id);
	}
}
