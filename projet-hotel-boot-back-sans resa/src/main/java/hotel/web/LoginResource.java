package hotel.web;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import hotel.dao.IDAOCompte;
import hotel.model.Client;
import hotel.model.Compte;
import hotel.model.views;
import hotel.web.dto.AuthDTO;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginResource {

	@Autowired
	private IDAOCompte daoCompte;

	@PostMapping("")
	@JsonView(views.ViewConnexion.class)
	public Compte login(@RequestBody AuthDTO auth) {
	//	String encodedString = "admin";
	//	System.out.println(Base64.getEncoder().withoutPadding().encodeToString(auth.getPassword().getBytes()));
		Compte conect = daoCompte.findByLoginAndPassword(auth.getLogin(), Base64.getEncoder().withoutPadding().encodeToString(auth.getPassword().getBytes()));
//		if (conect==null) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "login ou password incorect");
//		}
		
			return conect;

		}
	}

