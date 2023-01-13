package hotel.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hotel.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte,Integer> {
	
	@Query("SELECT c from Compte c where c.login = :login and c.password= :pasword")
	public Compte findByLoginAndPassword(String login, String password);

}


