package hotel;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hotel.dao.IDAOChambre;
import hotel.dao.IDAOClient;
import hotel.dao.IDAOCompte;
import hotel.dao.IDAOPassager;
import hotel.dao.IDAOPrestation;
import hotel.dao.IDAOReservation;
import hotel.model.Chambre;
import hotel.model.Client;
import hotel.model.Passager;
import hotel.model.Prestation;
import hotel.model.Reservation;
import hotel.model.TypeLogement;

@SpringBootApplication
public class ProjetHotelBootBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetHotelBootBackApplication.class, args);
	}

   //@Bean
    CommandLineRunner commandLineRunner(
    		IDAOClient daoClient, IDAOCompte daoCompte,
    		IDAOPassager daoPassager,
    		IDAOReservation daoReservation,
    		IDAOPrestation daoPrestation,
    		IDAOChambre daocChambre){
       


    	return args -> {
    		
    		


    		
            Stream.of("othmane","omar","clement").forEach(name->{
             Client client = new Client();
                client.setLogin(name);
                client.setNom(name);
                client.setNaissance(LocalDate.parse("2022-11-12"));
                client.setPrenom(name);
                client.setTelephone("122213121");
                client.setPassword("123456");
                client.setMail("hahah@kkkk");
                daoClient.save(client);
            });
            

            
            
            Stream.of("othmane","omar","clement").forEach(name->{
        		Passager passager = new Passager();
            	passager.setNom(name);
            	passager.setPrenom(name+"AZEE");
            	daoPassager.save(passager);
            });
            
            Stream.of("othmane","omar","clement").forEach(name->{
        		Reservation reservation = new Reservation();
        		reservation.setDateDebut(LocalDate.parse("2022-11-12"));
        		reservation.setDateFin(LocalDate.parse("2022-11-12"));
        		daoReservation.save(reservation);
            });
            
            Stream.of("othmane","omar","clement").forEach(name->{
        		Prestation reservationActivite = new Prestation();
        		reservationActivite.setDate(LocalDate.parse("2022-11-12"));
        		daoPrestation.save(reservationActivite);
            });
            
            Stream.of("othmane","omar","clement").forEach(name->{
            	Prestation presta = new Prestation();
            	presta.setNombre(3);
            	presta.setPrix((double) 1222);
        		daoPrestation.save(presta);
            });
            
            Stream.of(TypeLogement.suite,TypeLogement.chambresimple,TypeLogement.suitepresidentielle).forEach(name->{
            	Chambre chambre = new Chambre();
            	chambre.setType(name);
            	daocChambre.save(chambre);
            });
            
            
            for (int i = 0; i < 3; i++) {
            	Reservation r = new  Reservation();
            	
			}
            
            
            
            
            
            
            
        };
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
