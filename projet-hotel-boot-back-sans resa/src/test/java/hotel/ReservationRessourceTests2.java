package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import hotel.model.Chambre;
import hotel.model.Compte;
import hotel.model.Passager;
import hotel.model.TypeLogement;
import hotel.web.LoginResource;
import hotel.web.ReservationResource;
import hotel.web.SubscribeResource;
import hotel.web.dto.CreateCompteDto;
import hotel.web.dto.ReservationDto;

@SpringBootTest
class ReservationRessourceTests2 {
	@Autowired
	private ReservationResource resRes;
	@Autowired
	private LoginResource logRes;
	@Autowired
	private SubscribeResource subRes;
	
	


	@Test
	@Transactional
	@Rollback
	void testResa() {
		
		CreateCompteDto cdto= new CreateCompteDto();
		cdto.setClassName("Client");
		cdto.setLogin("client1");
		cdto.setPassword("pass1");
		cdto.setMail("test@cdto.fr");
		cdto.setNom("nom");
		cdto.setPrenom("prenomcdto");
		cdto.setTelephone("0619369265");
		cdto.setNaissance("2023-01-17");
		Compte c;
		 c=subRes.create(cdto);
		 Chambre ch1= new Chambre();
		 ch1.setId(1);
		 ch1.setType(TypeLogement.suite);
		 
		  Passager p1 = new Passager();
		  p1.setChambre(ch1);
		  p1.setId(1);
		  p1.setNom("Jacque");
		  p1.setPrenom("Atali");
		  p1.setNaissance(LocalDate.parse("1993-01-01"));		  
		  List<Passager> lp=new ArrayList<>();
		  lp.add(p1);
		  
		  ReservationDto resDTO= new ReservationDto();
		  resDTO.setDateDebut_resa(LocalDate.parse("1993-01-01"));
		  resDTO.setDateFin_resa(LocalDate.parse("1993-01-01"));
		  resDTO.setTypeLogement("suite");
//		  resDTO.setPassagers(p1);
		  
		 
		
		List<ReservationDto> resaDto=resRes.findall();
		System.out.println(resaDto);
	}
	
	@Test
	@Transactional
	@Rollback
	void testPersonnel() {
		
	}


}