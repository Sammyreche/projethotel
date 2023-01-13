package hotel.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hotel.model.Client;
import hotel.model.Compte;

public interface IDAOClient extends JpaRepository<Client,Integer> {
	
//	@Query("SELECT c from Client c where c.login = :login and c.password= :pasword")
//	public Client findByLoginAndPassword(String login, String password);

}


