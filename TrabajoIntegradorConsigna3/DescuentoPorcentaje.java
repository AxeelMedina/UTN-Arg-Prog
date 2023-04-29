public class DescuentoPorcentaje extends Descuento{
    private double valor;
    public double valorFinal(double valorInicial){
        valor=valorInicial-(valorInicial*this.dameValor());
        valor=Math.round(valor * 100) / 100d;//con 2 decimales
        return valor;

    }
}
