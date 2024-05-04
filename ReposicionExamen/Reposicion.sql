-- DROP DATABASE reposicion;
CREATE DATABASE reposicion;
USE reposicion;
CREATE TABLE IF NOT EXISTS usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(60) NOT NULL,
  password VARCHAR(25)NOT NULL,
  PRIMARY KEY (id_usuario) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE peliculas
 (
  nombre VARCHAR(45),
  clasificacion VARCHAR(45),
  subtitulado VARCHAR(45),
  idioma VARCHAR(45),
  tipo VARCHAR(45),
  precio double,
  PRIMARY KEY (clasificacion)
) ENGINE = InnoDB DEFAULT CHARSET=latin1;