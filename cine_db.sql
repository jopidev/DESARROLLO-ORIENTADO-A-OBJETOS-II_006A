CREATE DATABASE IF NOT EXISTS Cine_DB;
USE Cine_DB;

CREATE TABLE IF NOT EXISTS Cartelera (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    director VARCHAR(50) NOT NULL,
    anio INT NOT NULL,
    duracion INT,
    genero VARCHAR(30) NOT NULL
);

INSERT INTO Cartelera (titulo, director, anio, duracion, genero) VALUES
('Inception','Christopher Nolan',2010,148,'Ciencia Ficcion'),
('Titanic','James Cameron',1997,195,'Drama'),
('The Dark Knight','Christopher Nolan',2008,152,'Accion'),
('Forrest Gump','Robert Zemeckis',1994,142,'Drama'),
('The Matrix','Wachowski Sisters',1999,136,'Ciencia Ficcion'),
('Gladiator','Ridley Scott',2000,155,'Accion'),
('Avatar','James Cameron',2009,162,'Ciencia Ficcion'),
('The Shawshank Redemption','Frank Darabont',1994,142,'Drama'),
('Pulp Fiction','Quentin Tarantino',1994,154,'Crimen'),
('The Godfather','Francis Ford Coppola',1972,175,'Crimen');

CREATE INDEX idx_genero ON Cartelera (genero);
CREATE INDEX idx_anio ON Cartelera (anio);
