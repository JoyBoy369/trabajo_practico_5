package ar.edu.unju.fi.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.AlumnoService;

@Service
public class AlumnoImplementacionService implements AlumnoService {

    private List<Alumno> alumnos = new ArrayList<>();

    @Override
    public List<Alumno> getAllAlumnos() {
        return alumnos;
    }

    @Override
    public void saveAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    @Override
    public Alumno getAlumnoByDni(String dni) {
        return alumnos.stream().filter(a -> a.getDni().equals(dni)).findFirst().orElse(null);
    }

    @Override
    public void updateAlumno(Alumno alumno) {
        int index = -1;
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getDni().equals(alumno.getDni())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            alumnos.set(index, alumno);
        }
    }

    @Override
    public void deleteAlumno(String dni) {
        alumnos.removeIf(a -> a.getDni().equals(dni));
    }
}