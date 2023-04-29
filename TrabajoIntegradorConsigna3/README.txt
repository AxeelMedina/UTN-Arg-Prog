Este archivo es para comentar un par de observaciones del proyecto.

1- Usé un driver distinto al de las filminas de clase. Descargado de:
https://dev.mysql.com/downloads/connector/j/
Por ende, para utilizarlo hay que cambiar el string del Class.forName...
quedando de la siguiente manera:
Class.forName("com.mysql.cj.jdbc.Driver");
Todo esto está ya hecho en la clase ComunicacionBD.
Solo se debe seleccionar el driver manualmente una vez descargado. Si no 
se hace, se ejecuta igualmente pero da un aviso.

2-Trabajé siempre desde mi proyecto, por ende hay cosas distintas a lo
visto en clase.

3- Realicé las siguientes comprobaciones y excepciones:
Que el cliente esté registrando, sino debe registrarse.
Que el número del carrito sea mayor a 0.
Que el ID del producto sea mayor a 0.
Que la cantidad de producto sea mayor a 0.
Que el producto exista.
Que haya stock suficiente del producto (es decir que si no quedan, no pueden
venderse, y si quedan menos de los que el cliente quiere, tampoco).
No hay descuentos que hagan al precio a pagar menor a 0.
Entre otras.

4-Considero que hice lo que se pidió y más :D
