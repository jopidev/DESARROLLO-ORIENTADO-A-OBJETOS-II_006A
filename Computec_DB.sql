-- ==========================================================
--   BASE DE DATOS COMPUTEC - Evaluación Final Transversal
-- ==========================================================

-- 1. Crear base de datos
CREATE DATABASE IF NOT EXISTS Computec_DB;
USE Computec_DB;

-- ==========================================================
-- 2. Tabla CLIENTES
-- ==========================================================
CREATE TABLE IF NOT EXISTS clientes (
    rut VARCHAR(12) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    comuna VARCHAR(50) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL
);

-- ==========================================================
-- 3. Tabla EQUIPOS
-- ==========================================================
CREATE TABLE IF NOT EXISTS equipos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(150) NOT NULL,
    cpu VARCHAR(50) NOT NULL,
    disco INT NOT NULL,
    ram INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    tipo ENUM('Desktop','Laptop') NOT NULL,
    potenciaFuente INT NULL,
    factorForma VARCHAR(50) NULL,
    pantalla DOUBLE NULL,
    touch BOOLEAN NULL,
    puertosUsb INT NULL
);

-- ==========================================================
-- 4. Tabla VENTAS
-- ==========================================================
CREATE TABLE IF NOT EXISTS ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rutCliente VARCHAR(12) NOT NULL,
    idEquipo INT NOT NULL,
    fechaHora DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (rutCliente) REFERENCES clientes(rut) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (idEquipo) REFERENCES equipos(id) ON UPDATE CASCADE ON DELETE RESTRICT
);

-- ==========================================================
-- 5. Insertar datos de prueba
-- ==========================================================

-- Clientes
INSERT INTO clientes (rut, nombre, direccion, comuna, correo, telefono) VALUES
('11.111.111-1','Carlos Pérez','Av. Independencia 345','Santiago','carlos.perez@email.com','987654321'),
('22.222.222-2','Ana Morales','Los Héroes 1234','Maipú','ana.morales@email.com','912345678'),
('33.333.333-3','Pedro González','Av. O’Higgins 1010','Ñuñoa','pedro.gonzalez@email.com','934567890');

-- Equipos
INSERT INTO equipos (descripcion, cpu, disco, ram, precio, tipo, potenciaFuente, factorForma)
VALUES
('Desktop Gamer ASUS ROG','Intel i9',2000,32,1899000,'Desktop',750,'ATX'),
('Desktop HP Office','Intel i5',1000,16,649000,'Desktop',500,'Mini ATX');

INSERT INTO equipos (descripcion, cpu, disco, ram, precio, tipo, pantalla, touch, puertosUsb)
VALUES
('Laptop Lenovo ThinkPad','Intel i7',1000,16,899000,'Laptop',15.6,FALSE,3),
('Laptop MacBook Air','M2',512,8,1399000,'Laptop',13.3,TRUE,2);

-- Ventas
INSERT INTO ventas (rutCliente, idEquipo, total) VALUES
('11.111.111-1', 1, 1899000),
('22.222.222-2', 3, 899000),
('33.333.333-3', 4, 1399000);

-- ==========================================================
-- 6. Índices adicionales para rendimiento
-- ==========================================================
CREATE INDEX idx_equipo_tipo ON equipos(tipo);
CREATE INDEX idx_venta_fecha ON ventas(fechaHora);

-- ==========================================================
-- Fin del Script
-- ==========================================================
