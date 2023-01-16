package hotel.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import hotel.dao.IDAOClient;
import hotel.dao.IDAOPersonnel;
import hotel.model.Client;
import hotel.model.Personnel;
import hotel.model.views;

@RestController
@RequestMapping("/list")
@CrossOrigin("*")
public class PersonnelRessource {
	
	@Autowired
	private IDAOClient daoClient;
	@Autowired
	private IDAOPersonnel daoPersonnel;

	@GetMapping("/client")
	@JsonView(views.ViewConnexion.class)
	public List<Client> findAllClient(){
		List<Client> clients = daoClient.findAll();
		return clients ;
	}
	@GetMapping("/client/{id}")
	@JsonView(views.ViewConnexion.class)
	public Client findByIdClient(@PathVariable Integer id) {
		Optional<Client> client = daoClient.findById(id);

		if (client.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return client.get();
	}
	
	@PutMapping("/client/{id}")
	@JsonView(views.ViewConnexion.class)
	public Client update(@PathVariable Integer id, @RequestBody Client client) {
		if (id != client.getId() || !daoClient.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		client = daoClient.save(client);

		return client;
	}
	
	@GetMapping("/personnel")
	@JsonView(views.ViewConnexion.class)
	public List<Personnel> findAllPersonnel(){
		List<Personnel> personnels = daoPersonnel.findAll();
		return personnels ;
	}
	
	@DeleteMapping("/client/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoClient.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoClient.deleteById(id);
	}
	
	@GetMapping("/personnel/{id}")
	@JsonView(views.ViewConnexion.class)
	public Personnel findByIdPersonnel(@PathVariable Integer id) {
		Optional<Personnel> personnel = daoPersonnel.findById(id);

		if (personnel.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return personnel.get();
	}

}
