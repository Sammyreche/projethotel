package DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import model.Admin;

public interface IDAOAdmin extends JpaRepository<Admin,Integer> {

}


