package hotel.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import hotel.model.ReservationActivite;

public interface IDAOReservationActivite extends JpaRepository<ReservationActivite,Integer> {

}


