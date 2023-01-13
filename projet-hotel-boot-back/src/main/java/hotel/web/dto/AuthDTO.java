package hotel.web.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import hotel.model.TypeLogement;

public class AuthDTO {
	private String login;
	private String password;
	private Integer choix;
	
	
	public AuthDTO() {
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getChoix() {
		return choix;
	}


	public void setChoix(Integer choix) {
		this.choix = choix;
	}
	
	
	
}


