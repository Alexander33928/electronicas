create database urna2;
use urna2;

CREATE TABLE `elecciones` (
  `id_eleccion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_eleccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_eleccion`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

INSERT INTO `elecciones`(`nombre_eleccion`)
VALUES
("Presidente"),("Gobernador"),("Senador"),("Deputado Estadual"),("Deputado Federal");

CREATE TABLE `candidatos` (
  `id_candidato` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_candidato` varchar(45) DEFAULT NULL,
  `cargo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_candidato`),
  KEY `cargo` (`cargo`),
  CONSTRAINT `candidatos_ibfk_1` FOREIGN KEY (`cargo`) REFERENCES `elecciones` (`id_eleccion`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

INSERT INTO `candidatos`(`nombre_candidato`,`cargo`)
VALUES
("Anonimo1",1),("Anonimo2",1),("Anonimo3",2),("Anonimo4",2),("Anonimo5",3),("Anonimo6",3),("Anonimo7",4),("Anonimo8",4),("Anonimo9",5),("Anonimo10",5);

CREATE TABLE `votos` (
  `id_votos` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_votador` varchar(45) DEFAULT NULL,
  `credencial` varchar(45) DEFAULT NULL,
  `cantidad_votado` int(11) DEFAULT NULL,
  `candidatos_id` int(11) DEFAULT NULL,
  `eleccion_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_votos`),
  KEY `candidatos_id` (`candidatos_id`),
  KEY `eleccion_id` (`eleccion_id`),
  CONSTRAINT `votos_ibfk_1` FOREIGN KEY (`candidatos_id`) REFERENCES `candidatos` (`id_candidato`),
  CONSTRAINT `votos_ibfk_2` FOREIGN KEY (`eleccion_id`) REFERENCES `elecciones` (`id_eleccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


