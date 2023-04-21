import java.time.LocalDate;

public class Compras {

    public static void main(String[] args) {
        //instanciar a la clase Producto

        Producto p1 = new Producto(100,"Dulce de leche","Repostero x 500grs.",450.30,1000);
        Producto p2 = new Producto(101,"Leche","En polvo x 500grs.",200,1000);
        Producto p3 = new Producto(102,"Pan","Casero x 500grs.",150.30,500);
        Producto p4 = new Producto(103,"Café","Frasco x 500grs.",450.30,1000);


        Cliente c1 = new Cliente(101,26638449,"Hernandez Nelida", "Lavalle 500");

        Carrito carro = new Carrito(25,c1);

        ItemCarrito itemC[] = new ItemCarrito[3];

        itemC[0] = new ItemCarrito(carro,p1,2);
        itemC[1] = new ItemCarrito(carro,p2,5);
        itemC[2] = new ItemCarrito(carro,p3,1);
        itemC[0].mostrarTitulo();
        mostrarItems(itemC, carro, c1);

    }

    public static void mostrarItems(ItemCarrito vec[], Carrito carro, Cliente c1) {

        double total = 0.0;
        for (ItemCarrito lista:vec) {
            lista.mostrarItems();
            total = total + lista.dameMontoItem();
        }
        if(total>0) {
            carro.mostrarMontoTotal(total);
            calcularDescuentos(total);
        } else{
            carro.mostrarMontoTotal(total);
            System.out.println("No es posible aplicar descuentos a montos menores o iguales a 0");
        }

    }

    public static void calcularDescuentos(double total){

        LocalDate dia= LocalDate.now();
        int descuento=dia.getDayOfMonth();
        //int descuento=2; //para testear que con el descuento el monto no de negativo
        if((descuento%2==0)&&(descuento<=15)) {//si es dia par y de la primera quincena aplica desc fijo
            Descuento descFijo = new DescuentoFIjo();
            descFijo.asignarValorDesc(500);
            if(descFijo.valorFinal(total)<0){
                System.out.println("No es posible aplicar el descuento fijo porque el total sería negativo");
            }else
                System.out.println("El total a pagar con descuento es: " + descFijo.valorFinal(total));
        } else if((descuento%2==0)&&(descuento>15)){ //si es dia par y de la 2da quincena aplica descuento
                                                     // porcentual con tope fijo
            DescuentoPorcentajeConTope descPorConTope=new DescuentoPorcentajeConTope();
            descPorConTope.asignarValorDesc(0.4);
            descPorConTope.ingresarTopeFijo(1000);
            System.out.println("El total a pagar con descuento es: " + descPorConTope.valorFinal(total));
        } else {//si es impar aplica descuento porcentual
            Descuento descPorc= new DescuentoPorcentaje();
            descPorc.asignarValorDesc(0.5);
            System.out.println("El total a pagar con descuento es: "+descPorc.valorFinal(total));
        }
    }
}
