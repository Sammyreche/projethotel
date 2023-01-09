package hotel.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import hotel.model.Admin;

public interface IDAOAdmin extends JpaRepository<Admin,Integer> {

}


