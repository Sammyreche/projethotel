package hotel.web;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hotel.dao.IDAOCompte;
import hotel.model.Client;
import hotel.model.Compte;
import hotel.model.Personnel;
import hotel.web.dto.CreateCompteDto;

@RestController
@RequestMapping("/inscription")
@CrossOrigin("*")
public class SubscribeResource {
	 
	@Autowired
	private IDAOCompte daoCompte;
	
	@PutMapping("")
	public Compte create( @RequestBody CreateCompteDto compte) {
		if (compte.getClassName().equals("Client")) {
			Client client = new Client();
			client.setLogin(compte.getLogin());
			client.setPassword(compte.getPassword());
			client.setNom(compte.getNom());
			client.setPrenom(compte.getPrenom());
			client.setMail(compte.getMail());
			client.setTelephone(compte.getTelephone());
			client.setNaissance(LocalDate.parse(compte.getNaissance()));
			client= daoCompte.save(client);
			return client;
		} else {
			Personnel personnel = new Personnel();
				personnel.setNom(compte.getNom());
				personnel.setPrenom(compte.getPrenom());
				personnel.setLogin(compte.getLogin());
				personnel.setPassword(compte.getPassword());
			personnel = daoCompte.save(personnel);
			return personnel;

			}
			
		
		
	}
	
}
