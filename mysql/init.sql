-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS `listaProductos`;

-- Seleccionar la base de datos
USE `listaProductos`;

-- Crear la tabla si no existe
CREATE TABLE IF NOT EXISTS `productos` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(255) DEFAULT NULL,
    `descripcion` VARCHAR(255) DEFAULT NULL,
    `precio` DOUBLE DEFAULT NULL,
    PRIMARY KEY (`id`)
   
);


-- Insertar los datos
INSERT INTO `productos` (`nombre`, `descripcion`, `precio`) VALUES
("Metal Gear Solid", "Descripcion 1", 10.0),
("Splatoon 2", "Descripcion 2", 20.0),
("Mortal Kombat 1", "Descripcion 3", 30.0),
("Elder Ring", "Descripcion 4", 40.0),
("Booderlans 2", "Descripcion 5", 50.0),
("Skyrim", "Descripcion 6", 60.0),
("Silent Hill", "Descripcion 7", 70.0),
("The Witcher 3", "Descripcion 8", 80.0),
("Assassin's Creed", "Descripcion 9", 90.0),
("Resident Evil", "Descripcion 10", 100.0);
