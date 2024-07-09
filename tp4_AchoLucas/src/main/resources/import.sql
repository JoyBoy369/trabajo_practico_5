
-- Tabla carreras
insert carreras (carre_cod, carre_nombre, carre_cantidad_anios, carre_estado) values (21, 'ING', 5, b'1'), (22, 'MED', 7, b'1'), (23, 'DERECHO', 6, b'1'), (24, 'ARQ', 5, b'1'), (25, 'PSI', 6, b'1');

-- Tabla alumno
insert alumno (alu_dni, alu_nombre, alu_apellido, alu_email, alu_telefono, alu_fecha_nacimiento, alu_domicilio, alu_lu, alu_estado, carre_id) values ('12345679', 'Juan', 'Perez', 'juan@gmail.com', '223456789', '1999-02-01', 'Calle Falsa 123', '12346', b'1',1), ('12345680', 'Ana', 'Martinez', 'ana@gmail.com', '323456789', '2001-03-01', 'Av. Siempreviva 742', '12347', b'1',2),('12345681', 'Luis', 'Garcia', 'luis@gmail.com', '423456789', '2002-04-01', 'Calle Nueva 456', '12348', b'1',3),('12345682', 'Maria', 'Lopez', 'maria@gmail.com', '523456789', '2003-05-01', 'Av. Los Rosales 789', '12349', b'1',4),('12345683', 'Carlos', 'Sanchez', 'carlos@gmail.com', '623456789', '2004-06-01', 'Calle Principal 101', '12350', b'1',5);

-- Tabla docente
insert docente (doce_legajo, doce_nombre, doce_apellido, doce_email, doce_telefono, doce_estado) values (11, 'Gomez', 'Ramirez', 'gomez@gmail.com', '187654321', b'1'), (12, 'Silva', 'Mendez', 'silva@gmail.com', '287654321', b'1'), (13, 'Torres', 'Fernandez', 'torres@gmail.com', '387654321', b'1'), (14, 'Diaz', 'Gonzalez', 'diaz@gmail.com', '487654321', b'1'), (15, 'Ortiz', 'Castro', 'ortiz@gmail.com', '587654321', b'1');

-- Tabla materia
insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (40, 'PE', '1ro', 100, 'P', b'1', 1, 1),(50, 'HI1', '1ro', 10, 'V', b'1', 2, 1),(60, 'Visual', '2ro', 1, 'V', b'1', 3, 1),(70, 'HI2', '1ro', 10, 'P', b'1', 4, 2),(80, 'ED', '2ro', 1000, 'V', b'1', 5, 5);