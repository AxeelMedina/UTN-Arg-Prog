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
        carro.mostrarMontoTotal(total);
    }
}
