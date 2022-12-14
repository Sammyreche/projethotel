package DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import model.Reservation;

public interface IDAOReservation extends JpaRepository<Reservation,Integer> {

}


