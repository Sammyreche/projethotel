package hotel.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import hotel.model.Hotel;

public interface IDAOHotel extends JpaRepository<Hotel,Integer> {

}


