package hotel.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import hotel.model.Reservation;

public interface IDAOReservation extends JpaRepository<Reservation,Integer> {

}


