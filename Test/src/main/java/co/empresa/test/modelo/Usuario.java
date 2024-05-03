package co.empresa.test.modelo;

import java.io.Serializable;
import lombok.Data;

@Data
public class Usuario implements Serializable {

	private Integer id;
	private String nombre;
	private String email;
	private String pais;

}
