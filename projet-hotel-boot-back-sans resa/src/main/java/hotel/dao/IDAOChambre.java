package hotel.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import hotel.model.Chambre;

public interface IDAOChambre extends JpaRepository<Chambre,Integer> {

}


