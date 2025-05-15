-- Insertar estudiantes
INSERT INTO domi_students (id, code, name, program)
VALUES (1, 'A00001', 'Juan Pérez', 'SIS'),
       (2, 'A00002', 'María Gómez', 'SIS'),
       (3, 'A00003', 'Miguel Rodríguez', 'TEL'),
       (4, 'A00004', 'Lucía Fernández', 'DMI'),
       (5, 'A00005', 'Daniela Ramírez', 'TEL'),
       (6, 'A00006', 'Santiago Morales', 'SIS'),
       (7, 'A00007', 'Valentina Castro', 'DMI'),
       (8, 'A00008', 'Carlos Méndez', 'SIS'),
       (9, 'A00009', 'Javier Ortega', 'IBQ'),
       (10, 'A00010', 'Camila Rojas', 'MED'),
       (11, 'A00011', 'Andrés Herrera', 'ENI'),
       (12, 'A00012', 'Natalia Vargas', 'IBQ'),
       (13, 'A00013', 'Emiliano Suárez', 'SIS'),
       (14, 'A00014', 'Sofía León', 'TEL'),
       (15, 'A00015', 'Alejandro Pineda', 'IND'),
       (16, 'A00016', 'Isabela Cárdenas', 'PSI'),
       (17, 'A00017', 'Mateo Torres', 'DIS'),
       (18, 'A00018', 'Gabriela Mendoza', 'TEL'),
       (19, 'A00019', 'Luis Álvarez', 'DIS'),
       (20, 'A00020', 'Fernanda Espinosa', 'ENI');

-- Insertar profesores
INSERT INTO domi_professors (id, name)
VALUES (1, 'Gabriel Tamura'),
       (2, 'Ángela Villota'),
       (3, 'Andrés Aristizábal'),
       (4, 'Rocío Segovia'),
       (5, 'Claudia Castiblanco');

-- Insertar cursos
INSERT INTO domi_courses (id, name, professor_id)
VALUES (1, 'Ingeniería de Software IV', 1),
       (2, 'Computación y estructuras discretas III', 2),
       (3, 'Computación y estructuras discretas II', 3),
       (4, 'Ingeniería de Software III', 4),
       (5, 'Proyecto Integrador I', 5);

-- Insertar matriculas
INSERT INTO domi_enrollments (id, student_id, course_id)
VALUES
    -- Ingeniería de Software IV
    (1, 1, 1), (2, 2, 1), (3, 6, 1), (4, 8, 1), (5, 13, 1),

    -- Computación y estructuras discretas III
    (6, 1, 2), (7, 2, 2), (8, 3, 2), (9, 6, 2), (10, 14, 2),

    -- Computación y estructuras discretas II
    (11, 3, 3), (12, 5, 3), (13, 10, 3), (14, 12, 3), (15, 18, 3),

    -- Ingeniería de Software III
    (16, 1, 4), (17, 4, 4), (18, 6, 4), (19, 9, 4), (20, 13, 4),

    -- Proyecto Integrador I
    (21, 7, 5), (22, 8, 5), (23, 11, 5), (24, 15, 5), (25, 20, 5);


-- Insertar usuarios
INSERT INTO domi_users (id, email, password)
VALUES (1, 'estudiante@gmail.com', '$2a$12$LE5wWF2zJKLfE98E4KgJPO.buVfS0xHlSg2F2ciQMnk5kdgEBx506'),
       (2, 'profesor@gmail.com', '$2a$12$LE5wWF2zJKLfE98E4KgJPO.buVfS0xHlSg2F2ciQMnk5kdgEBx506'),
       (3, 'profesor@icesi.edu.co', '$2a$12$rI3WQHpIuzk3Hju56p.L/uLBmwXrVBPzqWhHXl4K1MKTqnfUtMeJe');

-- Insertar roles
INSERT INTO domi_roles (id, name)
VALUES (1, 'ROLE_STUDENT'),
       (2, 'ROLE_PROFESSOR');

-- Definir relaciones
INSERT INTO domi_user_roles (user_id, role_id)
VALUES (1, 1),
       (2, 2),
       (3, 2);


-- Configurar secuencia
SELECT setval('domi_users_seq', (SELECT MAX(id) FROM domi_users));
SELECT setval('domi_roles_seq', (SELECT MAX(id) FROM domi_roles));


SELECT setval('domi_professors_seq', (SELECT MAX(id) FROM domi_professors));
SELECT setval('domi_students_seq', (SELECT MAX(id) FROM domi_students));
SELECT setval('domi_courses_seq', (SELECT MAX(id) FROM domi_courses));
SELECT setval('domi_enrollments_seq', (SELECT MAX(id) FROM domi_enrollments));
SELECT setval('domi_users_seq', (SELECT MAX(id) FROM domi_users));