package ar.edu.unju.fi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "docente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doce_id")
    private Long id;
	
	@Column(name = "doce_legajo")
    private int legajo;
    
	@Column(name = "doce_nombre")
    private String nombre;
    
	@Column(name = "doce_apellido")
    private String apellido;
    
	@Column(name = "doce_email")
    private String email;
    
	@Column(name = "doce_telefono")
    private String telefono;

	@Column(name = "doce_estado")
	private boolean estado;

	public Docente(int legajo, String nombre, String apellido, String email, String telefono, boolean estado) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
	}
	
}
