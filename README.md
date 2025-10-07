# Gestión de Películas – Cine Magenta  
**Proyecto Final – Desarrollo Orientado a Objetos II (Semana 8)**  

---

## Descripción
Sistema de gestión de películas desarrollado en **Java (Swing + JDBC + MySQL)**.  
El proyecto implementa un CRUD completo y una búsqueda avanzada con filtros dinámicos, permitiendo administrar la cartelera de un cine a través de una interfaz gráfica intuitiva.

Incluye:
- Conexión estable a base de datos MySQL.  
- Operaciones CRUD completas (Agregar, Modificar, Eliminar).  
- Listado con **JTable** y filtros por **género** y **rango de años**.  
- Validaciones y cuadros de diálogo informativos.  
- Menú principal para navegación entre formularios.  

---

## Estructura del Proyecto
```
src/main/java/app/
 ├── DatabaseConnection.java
 ├── ModificarPeliculaFrame.java
 ├── EliminarPeliculaFrame.java
 ├── ListarPeliculasFrame.java
 ├── MenuPrincipalFrame.java
 └── Main.java
pom.xml
Cine_DB.sql
README.md
```

---

## ⚙️ Requisitos del sistema
- **JDK:** 21  
- **Maven:** 3.9 o superior  
- **MySQL:** 8.0+  
- **IDE recomendado:** VSCode o IntelliJ IDEA  
- **Sistema operativo:** Windows 10/11  

---

## Configuración de la Base de Datos
Ejecutar en MySQL Workbench o terminal:

```sql
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
```

---

## Ejecución del proyecto

### Desde consola (Maven):
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass=app.MenuPrincipalFrame
```

### Desde VSCode o IntelliJ:
Ejecutar la clase:
```
app.MenuPrincipalFrame
```

---

## Funcionalidades principales

<img width="379" height="239" alt="image" src="https://github.com/user-attachments/assets/3745932e-3d99-40f5-9d20-eaf22ef87dd2" />




### Agregar / Modificar / Eliminar
- Formulario con validaciones de campos obligatorios.

  <img width="393" height="335" alt="image" src="https://github.com/user-attachments/assets/2ba5f4fc-7eaf-4e6e-9289-91a0fb642da6" />

- Confirmación antes de eliminar.
- Mensajes de éxito o error según el resultado.





###  Listar y Buscar
- Muestra todas las películas en una `JTable`.
- Filtra por género (`JComboBox`) y rango de años (`JSpinner`).
- Botones:
  - **Buscar:** aplica filtros.
  - **Mostrar todas:** carga todos los registros.
  - **Limpiar:** reinicia filtros.

###  Menú Principal
- Acceso directo a los formularios desde un solo panel.

---

##  Pruebas realizadas
| Prueba | Resultado | Estado |
|--------|------------|--------|
| Conexión MySQL | Exitosa | ✅ |
| Insertar película | Insert correcto | ✅ |
| Modificar datos | Actualización exitosa | ✅ |
| Eliminar registro | Confirmación + eliminación | ✅ |
| Filtro por género y años | Filtrado dinámico correcto | ✅ |
| Botón limpiar | Restablece filtros y recarga tabla | ✅ |

---

## Autor
**Jorge Pinto**  
Estudiante de Ingeniería Informática mención Ciencia de Datos – DUOC UC  
Santiago, Chile  
GitHub: [@jopidev](https://github.com/jopidev)

---
