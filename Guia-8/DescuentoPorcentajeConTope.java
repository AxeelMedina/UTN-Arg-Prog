public class DescuentoPorcentajeConTope extends Descuento{
    private double topeFijo;
    public double valorFinal(double valorInicial){
        double porcentaje=valorInicial*this.dameValor();
        if(porcentaje>dameTopeFIjo()){
            return valorInicial-dameTopeFIjo();
        }
        else {
            return valorInicial-porcentaje;
        }
    }
    public void ingresarTopeFijo(double topeFijo){
        this.topeFijo=topeFijo;
    }
    public double dameTopeFIjo(){
        return topeFijo;
    }
}
