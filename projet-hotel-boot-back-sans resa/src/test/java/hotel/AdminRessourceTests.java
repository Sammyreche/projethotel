package hotel;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import hotel.model.Client;
import hotel.model.Compte;
import hotel.model.Personnel;
import hotel.web.AdminRessouce;
import hotel.web.LoginResource;
import hotel.web.PersonnelRessource;
import hotel.web.dto.AuthDTO;

@SpringBootTest
class AdminRessourceTests {
	@Autowired
	private AdminRessouce adminRes;
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
		
		adminRes.create(c1);
		
		AuthDTO auth=new AuthDTO();
		auth.setLogin(c1.getLogin());
		auth.setPassword(c1.getPassword());
		Compte c;
		c=logRes.login(auth);
		Integer idc = c.getId();
		adminRes.findAllClient();
		adminRes.findByIdClient(idc);
		c1.setNom("nom2");
		adminRes.updateClient(idc, c1);
		adminRes.deleteClient(idc);
	}
	
	@Test
	@Transactional
	@Rollback
	void testPersonnel() {
		Personnel p1=new Personnel();
		p1.setLogin("logp1");
		p1.setPassword("passp1");
		p1.setNom("nomp1");
		p1.setPrenom("prenomp1");
		
		adminRes.creatPersonnel(p1);
		
		AuthDTO auth=new AuthDTO();
		auth.setLogin(p1.getLogin());
		auth.setPassword(p1.getPassword());
		Compte c;
		c=logRes.login(auth);
		Integer idc = c.getId();
		
		adminRes.findAllPersonnel();		
		adminRes.findByIdPersonnel(idc);
		p1.setNom("nom2p1");
		adminRes.updatePersonnel(idc, p1);
		adminRes.deletePersonnel(idc);
	}


}