package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumno")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alu_id")
    private Long id;
	
	@Column(name = "alu_dni")
    private String dni;
	
	@Column(name = "alu_nombre")
    private String nombre;
	
	@Column(name = "alu_apellido")
    private String apellido;
	
	@Column(name = "alu_email")
    private String email;
	
	@Column(name = "alu_telefono")
    private String telefono;
    
	@Column(name = "alu_fechaNacimiento")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    
	@Column(name = "alu_domicilio")
    private String domicilio;
	
	@Column(name = "alu_lu")
    private String lu; // LU = Libreta Universitaria
    
	@Column(name = "alu_estado")
	private boolean estado;
    
    @ManyToMany(mappedBy = "alumnos")
    private List<Materia> materias = new ArrayList<Materia>();
    
    @ManyToOne
	@JoinColumn(name = "carre_id")
    private Carrera carrera;

	public Alumno(String dni, String nombre, String apellido, String email, String telefono, LocalDate fechaNacimiento,
			String domicilio, String lu, boolean estado, List<Materia> materias) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.lu = lu;
		this.estado = estado;
		this.materias = materias;
	}
	
}
