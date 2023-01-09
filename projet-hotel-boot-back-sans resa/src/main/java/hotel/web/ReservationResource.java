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
import hotel.model.Chambre;
import hotel.model.Passager;
import hotel.model.Prestation;
import hotel.model.Reservation;
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


	@GetMapping("")
	public List<ReservationDto> findall() {
		
		List<ReservationDto>  reservationDtos = new ArrayList<>();
		
		daoReservation.findAll().forEach(t -> reservationDtos.add(findById(t.getId())));

//		for (int i = 1; i < daoReservation.findAll().size(); i++) {
//			if (findById(i)!=null) {
//				reservationDtos.add(findById(i));
//			}
//		}

		return reservationDtos;
	}

	//aurevoir
	@GetMapping("/{id}/detail")
	public ReservationDto findById(@PathVariable Integer id) {
		ReservationDto reservationDto = new ReservationDto();
		if (!daoReservation.findById(id).isPresent()) {
			return reservationDto=null;
		}
		Reservation reservation = daoReservation.findById(id).get();
		if (!(reservation.getPassagers()==null)) {
			for (Passager passager : reservation.getPassagers()) {
				ReservationActivitePassagerDTO activitePassagerDTO = new ReservationActivitePassagerDTO();
				activitePassagerDTO.setId_passager(passager.getId());
				activitePassagerDTO.setNom_passager(passager.getNom());
				activitePassagerDTO.setPrenom_passager(passager.getPrenom());
				activitePassagerDTO.setNaissance_passager((passager.getNaissance()));
		//		if (!(passager.getResactivite().getPrestation().getTypeActivite()==null)) {
				if (!(passager.getPrestation()==null)) {
					activitePassagerDTO.setNombre(passager.getPrestation().getNombre());
					activitePassagerDTO.setId_prestation((passager.getPrestation().getId()));
					activitePassagerDTO.setDate(passager.getPrestation().getDate());
					if (passager.getPrestation().getTypeActivite()!=null) {
						activitePassagerDTO.setTypeActivite(passager.getPrestation().getTypeActivite().toString());
					}

					reservationDto.setId_chambre(passager.getChambre().getId());

				}
				reservationDto.getPassagers().add(activitePassagerDTO);
			}
		}
		reservationDto.setId(reservation.getId());
		reservationDto.setDateDebut_resa(reservation.getDateDebut());
		reservationDto.setDateFin_resa(reservation.getDateFin());
		if (!(reservation.getPassagers()==null)) {
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
		List<Passager> passagers = new ArrayList<>();
		
		Chambre chambre = new Chambre();
		

		reservation.setId(reservationDto.getId());
	//	reservation.setDateDebut(LocalDate.parse(reservationDto.getDateDebut_resa().toString()));
		reservation.setDateFin(reservationDto.getDateFin_resa());
		reservation.setDateDebut(reservationDto.getDateDebut_resa());


		if (!(reservationDto.getTypeLogement()==null)) {
							chambre.setType((TypeLogement.valueOf(reservationDto.getTypeLogement())));
						}
		if (!(reservationDto.getPassagers()==null)) {
				for (ReservationActivitePassagerDTO p : reservationDto.getPassagers()) {
					Passager passager = new Passager(); 
//					ReservationActivite activite = new ReservationActivite();
						passager.setChambre(chambre);
						passager.setId(p.getId_passager());
						passager.setNom(p.getNom_passager());
						passager.setPrenom(p.getPrenom_passager());
						passager.setNaissance(p.getNaissance_passager());

						
//							activite.setDate(p.getDate());
						Prestation prestation = new Prestation();
						prestation.setId(p.getId_passager());
						daoPrestation.save(prestation);

							if ((p.getTypeActivite()!=null)) {
								if (TypeActivite.valueOf(p.getTypeActivite())==TypeActivite.salledesport) {
									prestation.setNombre(p.getNombre());
									prestation.setDate(p.getDate());
									prestation.setTypeActivite(TypeActivite.salledesport);
									passager.setPrestation(prestation);
								
								} else if (TypeActivite.valueOf(p.getTypeActivite())==TypeActivite.restaurant) {
									//Prestation prestation = new Prestation();
									prestation.setNombre(p.getNombre());
									prestation.setDate(p.getDate());
									prestation.setTypeActivite(TypeActivite.restaurant);
								//	daoPrestation.save(prestation);
									passager.setPrestation(prestation);
								}	else if (TypeActivite.valueOf(p.getTypeActivite())==TypeActivite.spa) {
								//	Prestation prestation = new Prestation();
									prestation.setNombre(p.getNombre());
									prestation.setDate(p.getDate());
									prestation.setTypeActivite(TypeActivite.spa);
								//	daoPrestation.save(prestation);
									passager.setPrestation(prestation);

								}
							}
//						activite.setPassager(passager);
//						passager.setPrestation(prestation);
						
//						daoReservationActivite.save(activite);
//						daoChambre.save(chambre);
//						daoPassager.save(passager);
						System.out.println("avant le save");
						reservation.getPassagers().add(passager);
						
						passagers.add(passager);

						System.out.println("après le save");
				//System.out.println(passager);

			}
				
						
		}else {
			reservation.setPassagers(null);
			}
		Reservation reservationRecuperer=daoReservation.save(reservation);
//		
//		for (Passager passager : passagers) {
//			passager.setResa(reservationRecuperer);
//		}
//		reservation.getPassagers().addAll(passagers);
//		reservation=daoReservation.save(reservation);
//	
		System.out.println(passagers);
 
		return reservationRecuperer;
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
		Reservation r = daoReservation.findById(id).get();
		if (r.getPassagers()!=null) {
			daoReservation.delete(r);
			//r.getPassagers().forEach(t -> deletepassager(t.getId()));
		}else { 
			daoReservation.delete(r);
		}
		
	}

	@DeleteMapping("/passager/{id}")
	public void deletepassager(@PathVariable Integer id) {
		if (!daoPassager.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		Passager p=daoPassager.findById(id).get();
		System.out.println(p);
//		p.setChambre(null);
//		daoPassager.save(p);
//		ReservationActivite activite = daoReservationActivite.findById(p.getResactivite().getId()).get();
//		daoReservationActivite.delete(activite);
		daoPassager.delete(p);
	}





@PostMapping("/bis")
public ReservationDto createbis( @RequestBody ReservationDto reservationDto) {

	Reservation reservation = new Reservation();
	reservation.setId(reservationDto.getId());
	reservation = daoReservation.save(reservation);
	System.out.println("ok pour resa");
//	Passager passager = new Passager();
//	ReservationActivite activite = new ReservationActivite();
//	Prestation prestation = new SalleDeSport();
	Chambre chambre = new Chambre();
	chambre.setId(reservationDto.getId_chambre());
	
	chambre=daoChambre.save(chambre);	

//	chambre=daoChambre.save(chambre);

//	passager.setResa(reservation);
//	activite.setPassager(passager);
//	List<ReservationActivite> activites = new ArrayList<>();
//	prestation.setResaActivite(activites);
	List<Passager> passagers = new ArrayList<>();
	
	

	//reservation.setId(reservationDto.getId());
	reservation.setDateFin(reservationDto.getDateFin_resa());
	reservation.setDateDebut(reservationDto.getDateDebut_resa());


	if (!(reservationDto.getTypeLogement()==null)) {
						chambre.setType((TypeLogement.valueOf(reservationDto.getTypeLogement())));
					}
	if (!(reservationDto.getPassagers().isEmpty())) {
		int i = 0;
			for (ReservationActivitePassagerDTO p : reservationDto.getPassagers()) {
				
				Passager passager = new Passager();
				passager.setResa(reservation);
				
				//passager=daoPassager.save(passager);
			//	ReservationActivite activite = new ReservationActivite();
			//	activite = daoReservationActivite.save(activite);
			
				
				passager.setChambre(chambre);
				

					passager.setId(p.getId_passager());
					passager=daoPassager.save(passager);

					passager.setNom(p.getNom_passager());
					passager.setPrenom(p.getPrenom_passager());
					passager.setNaissance(p.getNaissance_passager());
					Prestation prestation = new Prestation();
					
			//			activite.setDate(p.getDate());

					
						if ((p.getTypeActivite()!=null)) {
							if (TypeActivite.valueOf(p.getTypeActivite())==TypeActivite.salledesport) {
							//	Prestation prestation = new Prestation();
								prestation.setId(p.getId_prestation());
							//	prestation = daoPrestation.save(prestation);
								prestation.setNombre(p.getNombre());
								prestation.setTypeActivite(TypeActivite.salledesport);
								prestation.setDate(p.getDate());
								//prestation=daoPrestation.save(prestation);
				//				activite.setPrestation(prestation);
				//				activite.setPassager(passager);
							} else if (TypeActivite.valueOf(p.getTypeActivite())==TypeActivite.restaurant) {
								System.out.println("ok pour resto");
							//	Prestation prestation = new Prestation();
								prestation.setId(p.getId_prestation());
								//prestation = daoPrestation.save(prestation);
								prestation.setNombre(p.getNombre());
								prestation.setTypeActivite(TypeActivite.restaurant);
								prestation.setDate(p.getDate());
								//prestation=daoPrestation.save(prestation);
				//				activite.setPrestation(prestation);
				//				activite.setPassager(passager);
							}	else if (TypeActivite.valueOf(p.getTypeActivite())==TypeActivite.spa) {
								System.out.println("ok pour spa");
								
								prestation.setId(p.getId_prestation());
								//prestation = daoPrestation.save(prestation);
								prestation.setNombre(p.getNombre());
								prestation.setTypeActivite(TypeActivite.spa);
								prestation.setDate(p.getDate());
								//prestation=daoPrestation.save(prestation);
				//				activite.setPrestation(prestation);
				//				activite.setPassager(passager);

							}
						}
						passager=daoPassager.save(passager);
						passager.setPrestation(prestation);
						prestation=daoPrestation.save(prestation);
						

//					activite.setPassager(passager);
		//			activite=daoReservationActivite.save(activite);
		//			passager.setResactivite(activite);
//					passager.setResa(reservation);
//					reservation = daoReservation.save(reservation);
//					reservation.getPassagers().forEach(t -> t.setResa(reservation) );
//					passager.getResa().setId(reservation.getId());
					passagers.add(passager);

					passager=daoPassager.save(passager);
		//			activite.setPassager(passager);
					System.out.println("avant le save");
					//reservation.setPassagers(passagers);
					reservation.getPassagers().add(passager);
					

					System.out.println("après le save");
			//System.out.println(passager);
					i++;

		}
			
					
	}else {
		reservation.setPassagers(null);
		}
	
	reservation=daoReservation.save(reservation);
	
	ReservationDto resultat = findById(reservation.getId());
	return resultat;
}

}