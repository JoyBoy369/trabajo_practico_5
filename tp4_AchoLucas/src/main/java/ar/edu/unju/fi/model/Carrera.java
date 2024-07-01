package ar.edu.unju.fi.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carreras")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carre_id")
    private Long id;
	
	@Column(name = "carre_cod")
    private int codigo;
	
	@Column(name = "carre_nombre")
    private String nombre;
	
	@Column(name = "carre_cantidadAnios")
    private int cantidadAnios;
	
	@Column(name = "carre_estado")
    private boolean estado;

	@OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Materia> materias;

	public Carrera(int codigo, String nombre, int cantidadAnios, boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadAnios = cantidadAnios;
		this.estado = estado;
	}
	
}

