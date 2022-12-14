package DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import model.Client;

public interface IDAOClient extends JpaRepository<Client,Integer> {

}


