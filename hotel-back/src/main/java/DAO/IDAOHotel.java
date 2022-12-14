package DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import model.Hotel;

public interface IDAOHotel extends JpaRepository<Hotel,Integer> {

}


