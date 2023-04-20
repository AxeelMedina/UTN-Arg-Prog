public class DescuentoPorcentaje extends Descuento{

    public double valorFinal(double valorInicial){
        return valorInicial-(valorInicial*this.dameValor());

    }
}
