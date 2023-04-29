import java.time.LocalDate;

public class ItemCarrito {
    private Carrito num;
    private Producto prod;
    private int cant;
    private double montoItem;


    public ItemCarrito(Carrito numero,Producto producto, int cant) {
        num=numero;
        prod = producto;
        this.cant = cant;
        montoItem = this.cant * prod.un_precio();
    }
    public int dameCant() {
        return cant;
    }
    public double dameMontoItem() {
        return montoItem;
    }
    public Producto dameProducto() {
        return prod;
    }
    public void mostrarTitulo() {
        System.out.println("Cant\tPrecio\tSubTotal\tProducto");
    }

    public void mostrarItems() {
        System.out.println(cant+"\t\t"+String.format("%.2f", prod.un_precio())+"\t\t\t"+String.format("%.2f", montoItem)+"\t\t"+prod.un_nombre());

    }

}

