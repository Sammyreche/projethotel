package hotel;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import hotel.model.Chambre;
import hotel.model.Client;
import hotel.model.Compte;
import hotel.model.TypeLogement;
import hotel.web.ListeReservationResource;
import hotel.web.LoginResource;
import hotel.web.ReservationResource;
import hotel.web.SubscribeResource;
import hotel.web.dto.CreateCompteDto;
import hotel.web.dto.ListeReservationDto;
import hotel.web.dto.ReservationDto;

@SpringBootTest
public class ListeReservationTest {

	@Autowired
	private SubscribeResource subRes;
	@Autowired
	private ListeReservationResource listeRes;
	
	
	@Test
	@Transactional
	@Rollback
	void testFindAllListeResa() {
		 
		Client cli = new Client();		//create client principal
		cli.setNom("Jay");
		cli.setPrenom("Jay");
		cli.setMail("jay@jay");
		cli.setTelephone("123433456");
		cli.setNaissance(LocalDate.parse("1993-01-21"));
		
		ListeReservationDto resDTO = new ListeReservationDto();	//DTO liste
		resDTO.setId(1);
		resDTO.setDateDebut_resa(LocalDate.parse("2022-01-19"));
		resDTO.setDateFin_resa(LocalDate.parse("2022-01-20"));
		resDTO.setNombrePassager(4);
		
		List<ListeReservationDto> listeResa =listeRes.findAll();
		System.out.println(listeResa);
		 
	}
	
	
//	@Test
//	@Transactional
//	@Rollback
//	void testFindByIdListeResa() {

 
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
