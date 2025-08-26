# Desarrollo Orientado a Objetos II

## Semana 2 - Patrones Decorator y Command

Se implementaron los patrones **Decorator** y **Command** sobre el caso de la tienda de ropa.  
El patrón **Decorator** permite aplicar distintos descuentos a los productos sin modificar su estructura base.  
El patrón **Command** encapsula acciones como agregar, eliminar productos y aplicar descuentos en el carrito.

### Estructura

src/
└─ main/java/app/
├─ Component.java
├─ Product.java
├─ Decorator.java
├─ PercentageDiscount.java
├─ CategoryDiscount.java
├─ Command.java
├─ AddToCartCommand.java
├─ RemoveFromCartCommand.java
├─ ApplyDiscountCommand.java
├─ Cart.java
└─ Main.java

### Ejecución

mvn clean package -DskipTests  
java -jar target/doo2-semana2-1.0.0.jar

### Ejemplo

Total antes de código: 73973.0  
Total después de código: 73958.0  
Total final: 58973.0
