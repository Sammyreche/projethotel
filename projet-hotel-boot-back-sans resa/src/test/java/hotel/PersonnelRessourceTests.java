package hotel;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import hotel.model.Client;
import hotel.model.Compte;
import hotel.model.Personnel;
import hotel.web.LoginResource;
import hotel.web.PersonnelRessource;
import hotel.web.dto.AuthDTO;

@SpringBootTest
class PersonnelRessourceTests {
	@Autowired
	private PersonnelRessource personelRes;
	@Autowired
	private LoginResource logRes;
	
	


	@Test
	@Transactional
	@Rollback
	void testClient() {
		Client c1 = new Client();
		c1.setLogin("client1");
		c1.setPassword("pass1");
		c1.setMail("test@c1.fr");
		c1.setNom("nom");
		c1.setPrenom("prenomc1");
		c1.setTelephone("0619369265");
		c1.setNaissance(LocalDate.parse("2023-01-17"));
		c1.setResa(null);
		
		personelRes.create(c1);
		
		AuthDTO auth=new AuthDTO();
		auth.setLogin(c1.getLogin());
		auth.setPassword(c1.getPassword());
		Compte c;
		c=logRes.login(auth);
		Integer idc = c.getId();
		personelRes.findAllClient();
		personelRes.findByIdClient(idc);
		c1.setNom("nom2");
		personelRes.update(idc, c1);
		personelRes.deleteClient(idc);
	}
	
	@Test
	@Transactional
	@Rollback
	void testPersonnel() {
		Personnel p = new Personnel();
		p.setLogin("perso");
		p.setPassword("perso");
		p.setNom("perso1");
		p.setSalaire(12);
		p.setPrenom("prenoperso");
		personelRes.create(p);
		List<Personnel> personels=personelRes.findAllPersonnel();		
		Personnel p1=personels.get(0);
		Integer idp = p1.getId();
		personelRes.findByIdPersonnel(idp);
	}


}