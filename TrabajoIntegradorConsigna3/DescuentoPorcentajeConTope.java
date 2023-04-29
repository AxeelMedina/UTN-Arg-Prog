public class DescuentoPorcentajeConTope extends Descuento{
    private double topeFijo;
    private double valor;
    public double valorFinal(double valorInicial){
        double porcentaje=valorInicial*this.dameValor();
        if(porcentaje>dameTopeFIjo()){
            valor=valorInicial-dameTopeFIjo();
            valor=Math.round(valor * 100) / 100d;//con 2 decimales
            return valor;
        }
        else {
            valor=valorInicial-porcentaje;
            valor=Math.round(valor * 100) / 100d;//con 2 decimales
            return valor;
        }
    }
    public void ingresarTopeFijo(double topeFijo){
        this.topeFijo=topeFijo;
    }
    public double dameTopeFIjo(){
        return topeFijo;
    }
}
