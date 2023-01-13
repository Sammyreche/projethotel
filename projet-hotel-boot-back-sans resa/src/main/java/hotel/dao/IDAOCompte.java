package hotel.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hotel.model.Client;
import hotel.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte,Integer> {
	
	@Query("SELECT c from Compte c where c.login = :login and c.password= :password")
	public Compte findByLoginAndPassword(@Param("login") String login,@Param("password") String password);

}


