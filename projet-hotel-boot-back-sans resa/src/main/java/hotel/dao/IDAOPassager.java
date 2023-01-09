package hotel.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import hotel.model.Passager;

public interface IDAOPassager extends JpaRepository<Passager,Integer> {

}


