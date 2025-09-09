# Desarrollo Orientado a Objetos II

## Semana 4 - Ciclo de vida de software e integración

Se desarrolló una aplicación de **gestión de inventario en Java** aplicando las fases del ciclo de vida del software, con foco en la **integración de sistemas** y el **aseguramiento de la calidad**.

### Funcionalidades
- Agregar, actualizar y eliminar productos
- Buscar por código o nombre
- Listar productos
- Generar informe de inventario
- Importar y exportar productos en formato CSV

### Estructura
src/
 ├─ main/java/app/
 │   ├─ Producto.java
 │   ├─ Inventario.java
 │   ├─ CsvAdapter.java
 │   └─ MenuPrincipal.java
 └─ test/java/app/
     ├─ ProductoTest.java
     └─ InventarioTest.java

### Ejecución
mvn clean test  
mvn clean package  
java -jar target/doo2-semana4-1.0.0.jar

### Ejemplo de uso
Archivo `productos.csv` de ejemplo para importar:

