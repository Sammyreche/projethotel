package hotel.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import hotel.model.Personnel;

public interface IDAOPersonnel extends JpaRepository<Personnel,Integer> {

}


