-- Tabla carreras
insert carreras (carre_cod, carre_nombre, carre_cantidad_anios, carre_estado) values (21, 'Ingenieria Informatica', 5, b'1'), (22, 'Medicina', 7, b'1'), (23, 'Derecho', 6, b'1'), (24, 'Arquitectura', 5, b'1'), (25, 'Psicologia', 6, b'1');

-- Tabla alumno
insert alumno (alu_dni, alu_nombre, alu_apellido, alu_email, alu_telefono, alu_fecha_nacimiento, alu_domicilio, alu_lu, alu_estado, carre_id) values ('87456321', 'Laura', 'Gomez', 'laura@gmail.com', '224567890', '2000-05-10', 'Av. Siempre Viva 742', '12348', b'1', 1);
insert alumno (alu_dni, alu_nombre, alu_apellido, alu_email, alu_telefono, alu_fecha_nacimiento, alu_domicilio, alu_lu, alu_estado, carre_id) values ('12345987', 'Martin', 'Rodriguez', 'martin@gmail.com', '224567891', '1998-08-15', 'Calle Corrientes 1234', '12349', b'1', 1);

insert alumno (alu_dni, alu_nombre, alu_apellido, alu_email, alu_telefono, alu_fecha_nacimiento, alu_domicilio, alu_lu, alu_estado, carre_id) values ('76543219', 'Sofia', 'Lopez', 'sofia@gmail.com', '224567892', '2001-11-20', 'Pasaje Luna 456', '12350', b'1', 2);
insert alumno (alu_dni, alu_nombre, alu_apellido, alu_email, alu_telefono, alu_fecha_nacimiento, alu_domicilio, alu_lu, alu_estado, carre_id) values ('97864531', 'Carlos', 'Martinez', 'carlos@gmail.com', '224567893', '1997-03-25', 'Calle Sol 789', '12351', b'1', 2);

insert alumno (alu_dni, alu_nombre, alu_apellido, alu_email, alu_telefono, alu_fecha_nacimiento, alu_domicilio, alu_lu, alu_estado, carre_id) values ('23546789', 'Lucia', 'Fernandez', 'lucia@gmail.com', '224567894', '1999-07-30', 'Av. Rivadavia 123', '12352', b'1', 3);
insert alumno (alu_dni, alu_nombre, alu_apellido, alu_email, alu_telefono, alu_fecha_nacimiento, alu_domicilio, alu_lu, alu_estado, carre_id) values ('14567892', 'Javier', 'Gutierrez', 'javier@gmail.com', '224567895', '2002-09-05', 'Calle Belgrano 456', '12353', b'1', 3);

insert alumno (alu_dni, alu_nombre, alu_apellido, alu_email, alu_telefono, alu_fecha_nacimiento, alu_domicilio, alu_lu, alu_estado, carre_id) values ('65437892', 'Ana', 'Silva', 'ana@gmail.com', '224567896', '2000-12-10', 'Pasaje San Martin 789', '12354', b'1', 4);
insert alumno (alu_dni, alu_nombre, alu_apellido, alu_email, alu_telefono, alu_fecha_nacimiento, alu_domicilio, alu_lu, alu_estado, carre_id) values ('45326789', 'Marcos', 'Ramirez', 'marcos@gmail.com', '224567897', '2001-04-15', 'Calle Mendoza 321', '12355', b'1', 4);

insert alumno (alu_dni, alu_nombre, alu_apellido, alu_email, alu_telefono, alu_fecha_nacimiento, alu_domicilio, alu_lu, alu_estado, carre_id) values ('34215678', 'Valeria', 'Gonzalez', 'valeria@gmail.com', '224567898', '1998-06-20', 'Av. Libertador 456', '12356', b'1', 5);
insert alumno (alu_dni, alu_nombre, alu_apellido, alu_email, alu_telefono, alu_fecha_nacimiento, alu_domicilio, alu_lu, alu_estado, carre_id) values ('23156789', 'Diego', 'Sanchez', 'diego@gmail.com', '224567899', '1997-01-25', 'Calle Moreno 789', '12357', b'1', 5);


-- Tabla docente
insert docente (doce_legajo, doce_nombre, doce_apellido, doce_email, doce_telefono, doce_estado) values (11, 'Gomez', 'Ramirez', 'gomez@gmail.com', '187654321', b'1'), (12, 'Silva', 'Mendez', 'silva@gmail.com', '287654321', b'1'), (13, 'Torres', 'Fernandez', 'torres@gmail.com', '387654321', b'1'), (14, 'Diaz', 'Gonzalez', 'diaz@gmail.com', '487654321', b'1'), (15, 'Ortiz', 'Castro', 'ortiz@gmail.com', '587654321', b'1');
insert docente (doce_legajo, doce_nombre, doce_apellido, doce_email, doce_telefono, doce_estado) values (31, 'Anna', 'MÃ¼ller', 'anna.muller@gmail.com', '467123456', b'1');
insert docente (doce_legajo, doce_nombre, doce_apellido, doce_email, doce_telefono, doce_estado) values (32, 'Lars', 'Johansson', 'lars.johansson@gmail.com', '467654321', b'1');
insert docente (doce_legajo, doce_nombre, doce_apellido, doce_email, doce_telefono, doce_estado) values (33, 'Sofia', 'Rossi', 'sofia.rossi@gmail.com', '468765432', b'1');
insert docente (doce_legajo, doce_nombre, doce_apellido, doce_email, doce_telefono, doce_estado) values (34, 'Thomas', 'Schneider', 'thomas.schneider@gmail.com', '469876543', b'1');
insert docente (doce_legajo, doce_nombre, doce_apellido, doce_email, doce_telefono, doce_estado) values (35, 'Emma', 'Garcia', 'emma.garcia@gmail.com', '462345678', b'1');
insert docente (doce_legajo, doce_nombre, doce_apellido, doce_email, doce_telefono, doce_estado) values (36, 'Lucas', 'Martin', 'lucas.martin@gmail.com', '463219876', b'1');
insert docente (doce_legajo, doce_nombre, doce_apellido, doce_email, doce_telefono, doce_estado) values (37, 'Olivia', 'Dubois', 'olivia.dubois@gmail.com', '465432198', b'1');
insert docente (doce_legajo, doce_nombre, doce_apellido, doce_email, doce_telefono, doce_estado) values (38, 'Jank', 'Nowak', 'jan.nowak@gmail.com', '469823654', b'1');
insert docente (doce_legajo, doce_nombre, doce_apellido, doce_email, doce_telefono, doce_estado) values (39, 'Isabella', 'Nielsen', 'isabella.nielsen@gmail.com', '461239876', b'1');
insert docente (doce_legajo, doce_nombre, doce_apellido, doce_email, doce_telefono, doce_estado) values (40, 'David', 'Popescu', 'david.popescu@gmail.com', '468732145', b'1');

-- Tabla materia
insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (40, 'Programacion Estructurada', '1ro', 100, 'Presencial', b'1', 1, 1);
insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (41, 'Estructura de Datos', '2do', 100, 'Virtual', b'1', 2, 1);
insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (42, 'Herramientas I', '2do', 100, 'Presencial', b'1', 3, 1);

insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (43, 'Fisiotria', '1ro', 100, 'Presencial', b'1', 4, 2);
insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (44, 'Biologia', '2ro', 100, 'Presencial', b'1', 5, 2);
insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (45, 'Huesitos II', '3ro', 100, 'Presencial', b'1', 6, 2);

insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (46, 'Abogacia I', '1ro', 100, 'Presencial', b'1', 7, 3);
insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (47, 'Culpabilidad', '3ro', 100, 'Virtual', b'1', 8, 3);
insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (48, 'Estudio Penal', '4to', 100, 'Presencial', b'1', 9, 3);

insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (49, 'Bloqueria', '1ro', 100, 'Virtual', b'1', 10, 4);
insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (50, 'Calculo', '2ro', 100, 'Virtual', b'1', 11, 4);
insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (51, 'Estadistica', '4to', 100, 'Presencial', b'1', 12, 4);

insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (52, 'Dibujo Tecnico', '1ro', 100, 'Virtual', b'1', 13, 5);
insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (53, 'Depresion IV', '2ro', 100, 'Virtual', b'1', 14, 5);
insert materia (mate_cod, mate_nombre, mate_curso, mate_cantidad_horas, mate_modalidad, mate_estado, doce_id, carre_id) values (54, 'Sistemas', '4to', 100, 'Presencial', b'1', 15, 5);