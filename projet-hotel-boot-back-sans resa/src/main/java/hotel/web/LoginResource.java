package hotel.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hotel.dao.IDAOCompte;
import hotel.model.Compte;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginResource {
	
	@Autowired
	private IDAOCompte daoCompte;
	
	@GetMapping("")
	public Compte login(@PathVariable String login, String password) {
		Optional<Compte> optCompte = daoCompte.findByLoginAndPassword(login,password);

		if (optCompte.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "login ou mot de passe incorrect");
		}

		return optCompte.get();
	}

}
