# Desarrollo Orientado a Objetos II

## Semana 3 - MVC con Singleton, Decorator y Command

Se integró la arquitectura **MVC** al sistema de pedidos online para la tienda de ropa, manteniendo los patrones trabajados en semanas anteriores.

### Modelo
- Producto, Pedido, Usuario
- DiscountManager como Singleton
- Component, Decorator, PercentageDiscount, CategoryDiscount

### Vista
- ProductoView
- CarritoView
- DescuentoView

### Controlador
- ProductoController
- CarritoController
- DescuentoController

### Command
- Command (interfaz)
- AddToCartCommand
- RemoveFromCartCommand

### Ejecución
mvn clean package -DskipTests  
java -jar target/doo2-semana3-1.0.0.jar

### Ejemplo
Carrito:  
- Camisa Oxford $26991.0  
- Jeans Slim $31992.0  
- Cinturón Cuero $14990.0  
Total: $73973.0  

Descuento aplicado: SALE10  
Descuento aplicado: SALE10  
Descuento aplicado: SALE10  
Total con código: $66575.7  

Carrito:  
- Camisa Oxford $26991.0  
- Jeans Slim $31992.0  
Total: $58983.0
