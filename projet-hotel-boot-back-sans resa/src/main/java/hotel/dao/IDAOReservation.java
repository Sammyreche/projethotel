package hotel.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hotel.model.Reservation;

public interface IDAOReservation extends JpaRepository<Reservation,Integer> {

	
	@Query("SELECT r from Reservation r where  r.clientPrincipal.nom like %:kw% or r.clientPrincipal.prenom like %:kw%")
	public List<Reservation> findBykw(String kw);
	
	@Query("SELECT r from Reservation r where  r.clientPrincipal.nom like %:kw% or r.clientPrincipal.prenom like %:kw%")
	public Page<Reservation> findBykwPage(String kw,Pageable pageable);
	
	@Query("SELECT r from Reservation r where  r.clientPrincipal.id like :id")
	public Optional<List<Reservation>>  findByClientId(Integer id);

}


