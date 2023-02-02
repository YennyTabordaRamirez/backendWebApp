INSERT INTO regiones (nombre) VALUES('Suramerica');
INSERT INTO regiones (nombre) VALUES('Centroamerica');
INSERT INTO regiones (nombre) VALUES('Norteamerica');
INSERT INTO regiones (nombre) VALUES('Europa');
INSERT INTO regiones (nombre) VALUES('Asia');
INSERT INTO regiones (nombre) VALUES('Africa');
INSERT INTO regiones (nombre) VALUES('Oceania');
INSERT INTO regiones (nombre) VALUES('Antartida');

INSERT INTO clientes (region_id, nombre, apellido, email, fecha_creacion) VALUES( 1,'Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '2018-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, fecha_creacion) VALUES( 2,'Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02');
INSERT INTO clientes (region_id, nombre, apellido, email, fecha_creacion) VALUES( 3,'Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03');
INSERT INTO clientes (region_id, nombre, apellido, email, fecha_creacion) VALUES( 4,'Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04');
INSERT INTO clientes (region_id, nombre, apellido, email, fecha_creacion) VALUES( 5,'Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01');
INSERT INTO clientes (region_id, nombre, apellido, email, fecha_creacion) VALUES( 6,'Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10');
INSERT INTO clientes (region_id, nombre, apellido, email, fecha_creacion) VALUES( 7,'Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18');
INSERT INTO clientes (region_id, nombre, apellido, email, fecha_creacion) VALUES( 8,'John', 'Vlissides', 'john.vlissides@gmail.com', '2018-02-28');

--Creando insert de usuarios con sus roles
INSERT INTO `usuarios` (userName, password, enabled) VALUES('andres', '$2a$10$zRY6uIEd7seEERtHKo5cCeOF6Egotr537rI.Sc.ZP/fp.oVy7Mtv2', 1);
INSERT INTO `usuarios` (userName, password, enabled) VALUES('admin', '$2a$10$JnFTcrUB2K20mA2V3po9EOJNeVfFff.XMleDrLqc.hWYf8vms9bsW', 1);

INSERT INTO `roles` (nombre) VALUES('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, rol_id) VALUES(1,1);
INSERT INTO `usuarios_roles` (usuario_id, rol_id) VALUES(2,2);
INSERT INTO `usuarios_roles` (usuario_id, rol_id) VALUES(2,1);
