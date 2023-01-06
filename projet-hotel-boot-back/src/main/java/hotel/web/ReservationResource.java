package hotel.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import hotel.dao.IDAOChambre;
import hotel.dao.IDAOPassager;
import hotel.dao.IDAOPrestation;
import hotel.dao.IDAOReservation;
import hotel.dao.IDAOReservationActivite;
import hotel.model.Chambre;
import hotel.model.Passager;
import hotel.model.Prestation;
import hotel.model.Reservation;
import hotel.model.ReservationActivite;
import hotel.model.Resto;
import hotel.model.SalleDeSport;
import hotel.model.Spa;
import hotel.model.TypeActivite;
import hotel.model.TypeLogement;
import hotel.model.views;
import hotel.web.dto.ReservationActivitePassagerDTO;
import hotel.web.dto.ReservationDto;



@RestController
@RequestMapping("/reservations")
@CrossOrigin("*")
public class ReservationResource {

	@Autowired
	private IDAOReservation daoReservation;
	@Autowired
	private IDAOPassager daoPassager;
	@Autowired
	private IDAOPrestation daoPrestation;
	@Autowired
	private IDAOChambre daoChambre;
	@Autowired
	private IDAOReservationActivite daoReservationActivite;

	@GetMapping("")
	public List<ReservationDto> findall() {
		
		List<ReservationDto>  reservationDto = new ArrayList<>();

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
			activitePassagerDTO.setNom_passager(passager.getNom());
			activitePassagerDTO.setPrenom_passager(passager.getPrenom());
			activitePassagerDTO.setNom_passager(passager.getNom());
			activitePassagerDTO.setNom_passager(passager.getNom());
	//		if (!(passager.getResactivite().getPrestation().getTypeActivite()==null)) {
			if (!(passager.getResactivite()==null)) {
				activitePassagerDTO.setNombre(passager.getResactivite() == null ? null :passager.getResactivite().getPrestation().getNombre());
				activitePassagerDTO.setTypeActivite(passager.getResactivite().getPrestation().getTypeActivite().toString());
				activitePassagerDTO.setDate(passager.getResactivite().getDate());

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
	public Reservation create( @RequestBody ReservationDto reservationDto) {

		Reservation reservation = new Reservation();
		
		
		Chambre chambre = new Chambre();
		

		reservation.setId(reservationDto.getId());
	//	reservation.setDateDebut(LocalDate.parse(reservationDto.getDateDebut_resa().toString()));
		reservation.setDateFin(reservationDto.getDateFin_resa());
		reservation.setDateDebut(reservationDto.getDateDebut_resa());


		if (!(reservationDto.getTypeLogement()==null)) {
							chambre.setType((TypeLogement.valueOf(reservationDto.getTypeLogement())));
						}
		if (!(reservationDto.getPassagers().isEmpty())) {
				for (ReservationActivitePassagerDTO p : reservationDto.getPassagers()) {
					Passager passager = new Passager(); 
					ReservationActivite activite = new ReservationActivite();
						passager.setChambre(chambre);
						passager.setId(p.getId_passager());
						passager.setNom(p.getNom_passager());
						passager.setPrenom(p.getPrenom_passager());
						passager.setNaissance(p.getNaissance_passager());

						
							activite.setDate(p.getDate());

						
							if ((p.getTypeActivite()!=null)) {
								if (TypeActivite.valueOf(p.getTypeActivite())==TypeActivite.gym) {
									Prestation prestation = new SalleDeSport();
									
									prestation.setNombre(p.getNombre());
									prestation.setTypeActivite(TypeActivite.gym);
									//daoPrestation.save(prestation);
									activite.setPrestation(prestation);
								
								} else if (TypeActivite.valueOf(p.getTypeActivite())==TypeActivite.restaurant) {
									System.out.println("ok pour resto");
									Prestation prestation = new Resto();
									prestation.setNombre(p.getNombre());
									prestation.setTypeActivite(TypeActivite.restaurant);
									//daoPrestation.save(prestation);
									activite.setPrestation(prestation);
								}	else if (TypeActivite.valueOf(p.getTypeActivite())==TypeActivite.spa) {
									System.out.println("ok pour spa");
									Prestation prestation = new Spa();
									prestation.setNombre(p.getNombre());
									prestation.setTypeActivite(TypeActivite.spa);
									//daoPrestation.save(prestation);
									activite.setPrestation(prestation);

								}
							}
//						activite.setPassager(passager);
						passager.setResactivite(activite);
						
//						daoReservationActivite.save(activite);
						daoChambre.save(chambre);
//						System.out.println("avant save passager");
//						daoPassager.save(passager);
//						System.out.println("après save passager");
				

						reservation.getPassagers().add(passager);
				System.out.println(passager);
				
				


			}
				
						
		}else {
			reservation.setPassagers(null);
			}

		//Reservation resa = daoReservation.findById(reservationDto.getId()).get();
		//passager.setResa(resa);
		
		reservation=daoReservation.save(reservation);

 
		return reservation;
	}

	
	
	
	
	
	
	
	@PutMapping("/{id}")
	public Reservation update(@PathVariable Integer id, @RequestBody ReservationDto reservationDto) {
		Reservation reservation = new Reservation();
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
