package hotel.web;

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

@RestController
@RequestMapping("/inscription")
@CrossOrigin("*")
public class SubscribeResource {
	
	@Autowired
	private IDAOCompte daoCompte;
	
	@PutMapping("")
	public Client create(@Valid @RequestBody Client client, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le client n'a pu être créé");
		}
		client= daoCompte.save(client);
		
		return client;
		
	}
	
}
