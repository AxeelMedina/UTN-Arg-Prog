import java.time.LocalDate;

public class Carrito {
    private int numC;
    private Cliente cli;
    private double montoTotal;
    private double montoConDesc;
    private LocalDate fecha;
    public Carrito(int num, Cliente cliente, LocalDate fecha) {
        numC =num;
        cli = cliente;
        montoTotal = 0.0;
        montoConDesc=0.0;
        this.fecha=fecha;
    }
    public int dameNumC() {
        return numC;
    }
    public Cliente dameCliente() {
        return cli;
    }
    public double dameMontoTotal() {
        return montoTotal;
    }
    public void agregarMontoTotal(double monto){montoTotal=monto;}
    public void mostrarMontoTotal() {
        System.out.println("El monto total del Carrito es : "+ montoTotal);
    }
    public void agregarMontoConDesc(double montoConDesc){
        this.montoConDesc=montoConDesc;
    }
    public double dameMontoConDescuento(){
        return montoConDesc;
    }
    public LocalDate dameDia(){
        return fecha;
    }


}
