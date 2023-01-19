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
import hotel.web.dto.ReservationActivitePassagerDTO;
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
	void testResaspa() {
		
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
		  
		  ReservationActivitePassagerDTO resactipsto = new ReservationActivitePassagerDTO();
		  resactipsto.setId_passager(p1.getId());
		  resactipsto.setNom_passager(p1.getNom());
		  resactipsto.setPrenom_passager(p1.getPrenom());
		  resactipsto.setNaissance_passager(p1.getNaissance());
		  resactipsto.setDate(LocalDate.parse("2023-01-01"));
		  resactipsto.setId_prestation(1);
		  resactipsto.setNombre(1);
		 resactipsto.setTypeActivite("spa");
		  List<ReservationActivitePassagerDTO> listresacti = new ArrayList<>();
		  listresacti.add(resactipsto);
		  
		  ReservationDto resDTO= new ReservationDto();
		  resDTO.setDateDebut_resa(LocalDate.parse("1993-01-01"));
		  resDTO.setDateFin_resa(LocalDate.parse("1993-01-01"));
		  resDTO.setTypeLogement("suite");
		  resDTO.setPassagers(listresacti);
		  resDTO.setId_chambre(1);
		  
		 resRes.createbisAjoutPassager(resDTO, c.getId());
		
		//resRes.findall();
	}
	
	@Test
	@Transactional
	@Rollback
void testResasalledesport() {
		
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
		  
		  ReservationActivitePassagerDTO resactipsto = new ReservationActivitePassagerDTO();
		  resactipsto.setId_passager(p1.getId());
		  resactipsto.setNom_passager(p1.getNom());
		  resactipsto.setPrenom_passager(p1.getPrenom());
		  resactipsto.setNaissance_passager(p1.getNaissance());
		  resactipsto.setDate(LocalDate.parse("2023-01-01"));
		  resactipsto.setId_prestation(1);
		  resactipsto.setNombre(1);
		 resactipsto.setTypeActivite("salledesport");
		  List<ReservationActivitePassagerDTO> listresacti = new ArrayList<>();
		  listresacti.add(resactipsto);
		  
		  ReservationDto resDTO= new ReservationDto();
		  resDTO.setDateDebut_resa(LocalDate.parse("1993-01-01"));
		  resDTO.setDateFin_resa(LocalDate.parse("1993-01-01"));
		  resDTO.setTypeLogement("suite");
		  resDTO.setPassagers(listresacti);
		  resDTO.setId_chambre(1);
		  
		 resRes.createbisAjoutPassager(resDTO, c.getId());
	}


	@Test
	@Transactional
	@Rollback
void testResaresto() {
		
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
		  
		  ReservationActivitePassagerDTO resactipsto = new ReservationActivitePassagerDTO();
		  resactipsto.setId_passager(p1.getId());
		  resactipsto.setNom_passager(p1.getNom());
		  resactipsto.setPrenom_passager(p1.getPrenom());
		  resactipsto.setNaissance_passager(p1.getNaissance());
		  resactipsto.setDate(LocalDate.parse("2023-01-01"));
		  resactipsto.setId_prestation(1);
		  resactipsto.setNombre(1);
		 resactipsto.setTypeActivite("restaurant");
		  List<ReservationActivitePassagerDTO> listresacti = new ArrayList<>();
		  listresacti.add(resactipsto);
		  
		  ReservationDto resDTO= new ReservationDto();
		  resDTO.setDateDebut_resa(LocalDate.parse("1993-01-01"));
		  resDTO.setDateFin_resa(LocalDate.parse("1993-01-01"));
		  resDTO.setTypeLogement("suite");
		  resDTO.setPassagers(listresacti);
		  resDTO.setId_chambre(1);
		  
		 resRes.createbisAjoutPassager(resDTO, c.getId());
	}
	
	@Test
	@Transactional
	@Rollback
void testfindall() {
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
		  
		  ReservationActivitePassagerDTO resactipsto = new ReservationActivitePassagerDTO();
		  resactipsto.setId_passager(p1.getId());
		  resactipsto.setNom_passager(p1.getNom());
		  resactipsto.setPrenom_passager(p1.getPrenom());
		  resactipsto.setNaissance_passager(p1.getNaissance());
		  resactipsto.setDate(LocalDate.parse("2023-01-01"));
		  resactipsto.setId_prestation(1);
		  resactipsto.setNombre(1);
		 resactipsto.setTypeActivite("spa");
		  List<ReservationActivitePassagerDTO> listresacti = new ArrayList<>();
		  listresacti.add(resactipsto);
		  
		  ReservationDto resDTO= new ReservationDto();
		  resDTO.setDateDebut_resa(LocalDate.parse("1993-01-01"));
		  resDTO.setDateFin_resa(LocalDate.parse("1993-01-01"));
		  resDTO.setTypeLogement("suite");
		  resDTO.setPassagers(listresacti);
		  resDTO.setId_chambre(1);
		  
		// resRes.createbisAjoutPassager(resDTO, c.getId());
		
		  List<ReservationDto>  listresa = resRes.findall();
		  ReservationDto res=new ReservationDto();
		 res= listresa.get(1);
		 res.setDateDebut_resa(LocalDate.parse("1992-01-01"));
		 //resRes.update(res.getId(), res);
		 
		
	}
}