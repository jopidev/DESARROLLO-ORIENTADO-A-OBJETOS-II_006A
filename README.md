# Desarrollo Orientado a Objetos II

## Semana 1 - Patrón Singleton

Se implementó el patrón Singleton a través de la clase `DiscountManager`, que garantiza una única instancia para aplicar descuentos en un sistema de pedidos online de una tienda de ropa.

### Estructura
src/
 ├─ main/java/app/DiscountManager.java
 └─ main/java/app/Main.java

### Ejecución
mvn clean package
java -jar target/tienda-descuentos-1.0.0.jar

### Ejemplo
Precio base: 49990.0
SALE10: 44991.0
VIP20: 39992.0
OFF5: 49985.0
NADA: 49990.0
