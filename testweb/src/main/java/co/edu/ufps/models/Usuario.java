package co.edu.ufps.models;

import java.util.Date;

import lombok.Data;

@Data
public class Usuario {
	private String username;
	private String name;
	private String email;
	private Date dateCreated;
	private String state;
}
