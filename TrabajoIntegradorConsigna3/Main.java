import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mensajeBienvenida();
        //Creamos objeto encargado de la comunicación con la base de datos
        ComunicacionBD comunic = new ComunicacionBD();

        //Pido al cliente que se identifique con su ID, podría ser con su CUIL/CUIT
        Cliente c1= consultarCliente(comunic);

        //Una vez identificado el cliente, se cobran sus productos, siempre y cuando
        //existan y haya stock
        pideProductos(c1,comunic);
        System.out.println("------------------------------------------");

        //Si lo desea, pude ver su historial de compras, siempre y cuando haya hecho alguna.
        mostrarHistorialDeCompras(comunic,c1);
    }

    public static void mensajeBienvenida(){
        System.out.println("Bienvenido al SuperMercado Axel!!!");
        System.out.println("Por favor identifíquese para ser atendido.");
        System.out.println("----------+++++++----------+++++++--------");
    }

    public static Cliente consultarCliente(ComunicacionBD comunic) {
        System.out.println("Ingrese su CUIL/CUIT sin guiones ni espacios: ");
        Scanner scn = new Scanner(System.in);
        int id;
        long cuil = scn.nextLong();

        //Se verifica que esté registrado en nuestra base de datos,
        //de lo contrario debe registrarse o colocar bien su CUIL/CUIT
        ResultSet sql2 = comunic.consultarCuil(cuil);
        while (sql2 == null) {
            System.out.println("Usted no se encuentra registrado.");
            System.out.println("Si desea crearse un usuario presione 1, si cree que es un error");
            System.out.println("y quiere colocar su CUIL/CUIT nuevamente, presione 2: ");
            id = scn.nextInt();
            if (id == 1) {
                cuil=comunic.crearClienteBD();
            } else {
                System.out.println("Reingrese su CUIL/CUIT sin guiones ni espacios: ");
                cuil = scn.nextLong();
            }
            sql2 = comunic.consultarCuil(cuil);
        }
        return comunic.crearCliente(cuil);
    }

    public static void pideProductos(Cliente c1, ComunicacionBD comunic){
        Scanner scn = new Scanner(System.in);
        int id;
        int max;
        LocalDate dia = LocalDate.now();
        //Se le pregunta qué productos comprará,
        //pidiendo un código que podría ser el resultado de
        //escanear el código de barras. Y también la cantidad.
        System.out.println("Ingrese el número de carrito: ");
        id = scn.nextInt();
        while(id<=0){
            System.out.println("Ingrese un número mayor a 0: ");
            id = scn.nextInt();
        }
        Carrito carro = new Carrito(id, c1, dia);
        ArrayList<ItemCarrito> itemC = new ArrayList<>();
        int agregar = 1;
        while (agregar == 1) {
            System.out.println("Ingrese el código de producto: ");
            id = scn.nextInt();
            max=comunic.ultimoIndiceProducto();
            while((id>max)||(id<=0)){
                System.out.println("Ese código no existe, pruebe desde 1 a "+max+":");
                id = scn.nextInt();
            }
            System.out.println("Cuántas unidades?");
            int cantidad = scn.nextInt();
            while(cantidad<=0){
                System.out.println("Por favor ingrese un número mayor a 0:");
                cantidad = scn.nextInt();
            }
            ComunicacionBD consultas = new ComunicacionBD();
            int validacion = consultas.validarProducto(id, cantidad);
            while (validacion == 0) {
                System.out.println("Ingrese otro código de producto");
                id = scn.nextInt();
                System.out.println("Cuántas unidades?");
                cantidad = scn.nextInt();
                validacion = consultas.validarProducto(id, cantidad);
            }
            while (validacion == 1) {
                cantidad = scn.nextInt();
                validacion = consultas.validarProducto(id, cantidad);
            }
            //crea el producto con los datos de la base de datos
            Producto p = consultas.dameProducto(id, cantidad);
            itemC.add(new ItemCarrito(carro, p, cantidad));
            System.out.println("Si desea agregar otro producto presione 1, de lo contrario presione otro número: ");
            agregar = scn.nextInt();
        }
        //Cuando haya agregado el último producto, muestra los items del carrito
        mostrarItems(itemC, carro);
        //Agrega carrito a la base de datos
        comunic.agregarCarrito(c1, carro);
    }

    public static void mostrarItems(ArrayList<ItemCarrito> itemC, Carrito carro) {
        System.out.println("Cant\tPrecio Unitario\tPrecioxCant\tProducto");
        double total = 0.00;
        ItemCarrito lista;
        for (ItemCarrito itemCarrito : itemC) {
            lista = itemCarrito;
            lista.mostrarItems();
            total = total + lista.dameMontoItem();
        }

        total = Math.round(total * 100) / 100d;//con 2 decimales
        carro.agregarMontoTotal(total);
        carro.mostrarMontoTotal();
        if (total > 0) {
            calcularDescuentos(total, carro);
        } else {
            System.out.println("No es posible aplicar descuentos a montos menores o iguales a 0");
        }
    }

    public static void calcularDescuentos(double total, Carrito carro) {

        LocalDate dia = carro.dameDia();
        int descuento = dia.getDayOfMonth();
        double precioConDescuento;
        //int descuento=2; //para testear que con el descuento el monto no de negativo
        if ((descuento % 2 == 0) && (descuento <= 15)) {//si es día par y de la primera quincena aplica desc fijo
            Descuento descFijo = new DescuentoFIjo();
            descFijo.asignarValorDesc(500);
            if (descFijo.valorFinal(total) < 0) {
                System.out.println("No es posible aplicar el descuento fijo porque el total sería negativo");
                precioConDescuento = total;
            } else {
                System.out.println("El total a pagar con descuento es: " + descFijo.valorFinal(total));
                precioConDescuento = descFijo.valorFinal(total);
            }
        } else if ((descuento % 2 == 0) && (descuento > 15)) { //si es día par y de la 2da quincena aplica descuento
            // porcentual con tope fijo
            DescuentoPorcentajeConTope descPorConTope = new DescuentoPorcentajeConTope();
            descPorConTope.asignarValorDesc(0.4);
            descPorConTope.ingresarTopeFijo(1000);
            System.out.println("El total a pagar con descuento es: " + descPorConTope.valorFinal(total));
            precioConDescuento = descPorConTope.valorFinal(total);
        } else {//si es impar aplica descuento porcentual
            Descuento descPorc = new DescuentoPorcentaje();
            descPorc.asignarValorDesc(0.5);
            System.out.println("El total a pagar con descuento es: " + descPorc.valorFinal(total));
            precioConDescuento = descPorc.valorFinal(total);
        }
        carro.agregarMontoConDesc(precioConDescuento);
    }

    public static void mostrarHistorialDeCompras(ComunicacionBD comunic,Cliente c1){
        Scanner scn=new Scanner(System.in);
        System.out.println("Desea ver su historial de compras?");
        System.out.println("Presione 1, de lo contrario presione 2:");
        int nro=scn.nextInt();
        if(nro==1){
            comunic.dameCarritosPorIdC(c1);
        }
        System.out.println("-----------------------------");
        System.out.println("Adiós, gracias por su visita!");

    }
}
