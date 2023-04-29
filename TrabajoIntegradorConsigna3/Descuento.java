public abstract class Descuento{
    private double valor;

    public double dameValor(){
        return valor;
    }

    public void asignarValorDesc(double valor){
        this.valor=valor;
    }

    public abstract double valorFinal(double valorInicial);
}