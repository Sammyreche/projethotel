package hotel.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import hotel.dao.IDAOClient;
import hotel.dao.IDAOCompte;
import hotel.dao.IDAOPersonnel;
import hotel.dao.IDAOReservation;
import hotel.model.Client;
import hotel.model.Personnel;
import hotel.model.Reservation;
import hotel.model.views;

@RestController
@RequestMapping("/list")
@CrossOrigin("*")
public class PersonnelRessource {
	
	@Autowired
	private IDAOClient daoClient;
	@Autowired
	private IDAOPersonnel daoPersonnel;
	@Autowired
	private IDAOReservation daoResa;
	@Autowired
	private IDAOCompte daoCompte;

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
	
	@PostMapping("/client")
	public Client create(@Valid @RequestBody Client client/*, BindingResult result*/) {
//		if (result.hasErrors()) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le client n'a pu être créé");
//		}
		client= daoCompte.save(client);
		
		return client;
		
	}
	@DeleteMapping("/client/{id}")
	@JsonView(views.ViewConnexion.class)
	public void deleteClient(@PathVariable Integer id) {
		if (!daoClient.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		Client client = daoClient.findById(id).get();
		if(client.getResa()!=null) {
			for (Reservation r : client.getResa()) {
				daoResa.delete(r);
				
			}	
		}
		daoClient.deleteById(id);
	}
	
	@GetMapping("/personnel")
	@JsonView(views.ViewConnexion.class)
	public List<Personnel> findAllPersonnel(){
		List<Personnel> personnels = daoPersonnel.findAll();
		return personnels ;
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
	
	@DeleteMapping("/personnel/{id}")
    public void deletePersonnel(@PathVariable Integer id) {
        if (!daoPersonnel.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Personnel personnel = daoPersonnel.findById(id).get();

        daoPersonnel.deleteById(id);
    }
	
	@PostMapping("/personnel")
    @JsonView(views.ViewConnexion.class)
    public Personnel create(@RequestBody Personnel personnel) {
        personnel = daoPersonnel.save(personnel);

        return personnel;
    }

    @PutMapping("/personnel/{id}")
    @JsonView(views.ViewConnexion.class)
    public Personnel update(@PathVariable Integer id, @RequestBody Personnel personnel) {
    if (id != personnel.getId() || !daoPersonnel.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        personnel = daoPersonnel.save(personnel);

        return personnel;
    }

}
