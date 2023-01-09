package hotel.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import hotel.model.Prestation;

public interface IDAOPrestation extends JpaRepository<Prestation,Integer> {

}


