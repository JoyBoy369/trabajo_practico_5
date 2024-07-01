package ar.edu.unju.fi.model;



import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "materia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mate_id")
    private Long id;
	
	@Column(name = "mate_cod")
    private int codigo;
	
	@Column(name = "mate_nombre")
    private String nombre;
	
	@Column(name = "mate_curso")
    private String curso;
	
	@Column(name = "mate_cantidadHoras")
    private int cantidadHoras;
	
	@Column(name = "mate_modalidad")
    private String modalidad; // virtual o presencial
	
	@Column(name = "mate_estado")
	private boolean estado;
	
	@ManyToMany
	@JoinTable(name = "materias_alumnos",
	joinColumns = @JoinColumn(name = "mate_id"),
	inverseJoinColumns = @JoinColumn(name = "alu_id"))
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@OneToOne
	@JoinColumn(name = "doce_id")
    private Docente docente;
	
	@ManyToOne
	@JoinColumn(name = "carre_id")
    private Carrera carrera;

	public Materia(int codigo, String nombre, String curso, int cantidadHoras, String modalidad, boolean estado,
			List<Alumno> alumnos, Docente docente, Carrera carrera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.estado = estado;
		this.alumnos = alumnos;
		this.docente = docente;
		this.carrera = carrera;
	}
	
}
