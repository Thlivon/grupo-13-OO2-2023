use smartcity_unla;

INSERT INTO `user` (`id`, `createdat`, `enabled`, `password`, `updatedat`, `username`)
VALUES ('1', '2023-06-21 12:00:00', true, '$2a$10$dvrayGSAdw8aT.VQrAAzN.K4UJ72Nfcx1eRdnJfrG1c9OKpQpyImm', '2023-06-21 12:00:00', 'user');
INSERT INTO `user_role` (`id`, `createdat`, `role`, `updatedat`, `user_id`)
VALUES ('1','2023-06-21 12:00:00','ROLE_USER','2023-06-21 12:00:00','1');

INSERT INTO `user` (`id`, `createdat`, `enabled`, `password`, `updatedat`, `username`)
VALUES ('2', '2023-06-21 13:00:00', true, '$2a$10$mOx..msOZCiDm3sc3Hak7urtitkMlYVDJJvjAXvCPrHT0RNoqZUqG', '2023-06-21 13:00:00', 'admin');
INSERT INTO `user_role` (`id`, `createdat`, `role`, `updatedat`, `user_id`)
VALUES ('2','2023-06-21 13:00:00','ROLE_ADMIN','2023-06-21 13:00:00','2');

INSERT INTO `aula` (`luces_ycortinas`, `lugar`)
VALUES (false,"Jose Hernandez Aula 1");
INSERT INTO `aula` (`luces_ycortinas`, `lugar`)
VALUES (false,"Jose Hernandez Aula 2");
INSERT INTO `aula` (`luces_ycortinas`, `lugar`)
VALUES (false,"Jose Hernandez Aula 3");
INSERT INTO `aula` (`luces_ycortinas`, `lugar`)
VALUES (false,"Leopoldo Marechal Aula 1");
INSERT INTO `aula` (`luces_ycortinas`, `lugar`)
VALUES (false,"Leopoldo Marechal Aula 2");
INSERT INTO `aula` (`luces_ycortinas`, `lugar`)
VALUES (false,"Leopoldo Marechal Aula 3");
INSERT INTO `aula` (`luces_ycortinas`, `lugar`)
VALUES (false,"Homero Manzi Aula 1");
INSERT INTO `aula` (`luces_ycortinas`, `lugar`)
VALUES (false,"Homero Manzi Aula 2");
INSERT INTO `aula` (`luces_ycortinas`, `lugar`)
VALUES (false,"Homero Manzi Aula 3");

INSERT INTO `contenedor` (`lugar`)
VALUES ("Contenedor Jose Hernandez");
INSERT INTO `contenedor` (`lugar`)
VALUES ("Contenedor Leopoldo Marechal");
INSERT INTO `contenedor` (`lugar`)
VALUES ("Contenedor Homero Manzi");
INSERT INTO `contenedor` (`lugar`)
VALUES ("Contenedor Buffet");
INSERT INTO `contenedor` (`lugar`)
VALUES ("Contenedor Entrada Av. 29 Septiembre");
INSERT INTO `contenedor` (`lugar`)
VALUES ("Contenedor Entrada Pablo Nogués");
INSERT INTO `contenedor` (`lugar`)
VALUES ("Contenedor Entrada Av. Malabia");

INSERT INTO `espacio_verde` (`lugar`)
VALUES ("Espacio Verde Sector A");
INSERT INTO `espacio_verde` (`lugar`)
VALUES ("Espacio Verde Sector B");
INSERT INTO `espacio_verde` (`lugar`)
VALUES ("Espacio Verde Sector C");
INSERT INTO `espacio_verde` (`lugar`)
VALUES ("Espacio Verde Sector D");
INSERT INTO `espacio_verde` (`lugar`)
VALUES ("Espacio Verde Sector E");
INSERT INTO `espacio_verde` (`lugar`)
VALUES ("Espacio Verde Sector F");
INSERT INTO `espacio_verde` (`lugar`)
VALUES ("Espacio Verde Sector G");
INSERT INTO `espacio_verde` (`lugar`)
VALUES ("Espacio Verde Sector H");

INSERT INTO `habilitacion` (`habilitado`, `nombre`)
VALUES (false,'Camaras');
INSERT INTO `habilitacion` (`habilitado`, `nombre`)
VALUES (false,'Sensores Contenedor');
INSERT INTO `habilitacion` (`habilitado`, `nombre`)
VALUES (false,'Sensores Humedad');

