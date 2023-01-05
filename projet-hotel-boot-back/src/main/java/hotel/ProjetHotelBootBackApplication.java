package hotel;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hotel.dao.IDAOClient;
import hotel.dao.IDAOCompte;
import hotel.dao.IDAOPassager;
import hotel.dao.IDAOReservation;
import hotel.model.Client;
import hotel.model.Passager;
import hotel.model.Reservation;
import hotel.model.ReservationActivite;

@SpringBootApplication
public class ProjetHotelBootBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetHotelBootBackApplication.class, args);
	}

   // @Bean
    CommandLineRunner commandLineRunner(
    		IDAOClient daoClient, IDAOCompte daoCompte,
    		IDAOPassager daoPassager,
    		IDAOReservation daoReservation){
       


    	return args -> {
    		
    		
    		ReservationActivite activite = new ReservationActivite();


    		
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
            
            
            
            for (int i = 0; i < 3; i++) {
            	Reservation r = new  Reservation();
            	
			}
            
            
            
            
            
            
            
        };
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
