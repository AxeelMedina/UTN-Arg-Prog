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
        System.out.println(cant+"\t"+prod.un_precio()+"\t"+montoItem+"\t\t"+prod.un_nombre());
    }

}

