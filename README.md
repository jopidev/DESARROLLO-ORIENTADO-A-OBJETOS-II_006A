# Desarrollo Orientado a Objetos II

## Semana 5 - Trabajo colaborativo y mejoras de inventario

Se continuó con el proyecto de **gestión de inventario en Java**, aplicando mejoras solicitadas por el docente e integrando herramientas de trabajo colaborativo.

### Mejoras implementadas
- Validación de códigos duplicados en el inventario
- Validaciones adicionales en precio y cantidad
- Totales e información de valor inventario en el listado
- Manejo robusto de importación CSV (salta filas inválidas o duplicadas)
- Interfaz de consola más realista con tablas y formateo de moneda
- Nuevos casos de prueba unitarios y de integración

### Estructura
src/
 ├─ main/java/app/
 │   ├─ Producto.java
 │   ├─ Inventario.java
 │   ├─ CsvAdapter.java
 │   ├─ Ui.java
 │   └─ MenuPrincipal.java
 └─ test/java/app/
     ├─ ProductoTest.java
     └─ InventarioTest.java

### Ejecución
mvn clean test  
mvn clean package  
java -jar target/doo2-semana4-1.0.0.jar
