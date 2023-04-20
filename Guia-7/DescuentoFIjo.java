public class DescuentoFIjo extends Descuento{

    public double valorFinal(double valorInicial){
        return valorInicial-this.dameValor();

    }
}
