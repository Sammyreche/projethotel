package hotel.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import hotel.model.Client;

public interface IDAOClient extends JpaRepository<Client,Integer> {

}


