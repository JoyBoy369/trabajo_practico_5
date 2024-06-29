package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public interface AlumnoService {
    List<Alumno> getAllAlumnos();
    void saveAlumno(Alumno alumno);
    Alumno getAlumnoByDni(String dni);
    void updateAlumno(Alumno alumno);
    void deleteAlumno(String dni);
}