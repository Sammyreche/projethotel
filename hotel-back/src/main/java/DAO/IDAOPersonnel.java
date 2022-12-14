package DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import model.Personnel;

public interface IDAOPersonnel extends JpaRepository<Personnel,Integer> {

}


