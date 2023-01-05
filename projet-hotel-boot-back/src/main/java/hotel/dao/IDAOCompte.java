package hotel.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import hotel.model.Client;
import hotel.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte,Integer> {

}


