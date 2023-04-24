import java.util.Scanner;
public class Calculadora {
    private double resultado;
    private int contador=0;
    private boolean bandera=true; //variable que determina si seguiran utilizando la calculadora
    private double unNumero=0;
    private double otroNumero=0;
    public void verMenu(){
        System.out.println("Las opciones son: sumar - restar - dividir - multiplicar - limpiar - salir");
    }
    public void iniciar(){
        verMenu();
        Scanner scn = new Scanner(System.in);
        String operacion=scn.next();
        if(operacion.toLowerCase().equals("salir"))
            salir();
        while(bandera){
            if(operacion.toLowerCase().equals("limpiar")){
                limpiar();
            }
            else if((operacion.toLowerCase().equals("sumar"))&&(contador==0)){
                System.out.println("Ingrese los 2 valores:");
                unNumero=scn.nextDouble();
                otroNumero=scn.nextDouble();
                resultado=sumar(unNumero,otroNumero);
                contador++;
            } else if (operacion.toLowerCase().equals("sumar")){
                System.out.println("Ingrese el nuevo número:");
                unNumero=scn.nextDouble();
                resultado=sumar(resultado,unNumero);
            } else if ((operacion.toLowerCase().equals("restar"))&&(contador==0)){
                System.out.println("Ingrese los 2 valores:");
                unNumero=scn.nextDouble();
                otroNumero=scn.nextDouble();
                resultado=restar(unNumero,otroNumero);
                contador++;
            } else if(operacion.toLowerCase().equals("restar")){
                System.out.println("Ingrese el nuevo número:");
                unNumero=scn.nextDouble();
                resultado=restar(resultado,unNumero);
            }
            else if ((operacion.toLowerCase().equals("dividir"))&&(contador==0)){
                System.out.println("Ingrese los 2 valores:");
                unNumero=scn.nextDouble();
                otroNumero=scn.nextDouble();
                resultado=dividir(unNumero,otroNumero);
                contador++;
            } else if(operacion.toLowerCase().equals("dividir")){
                System.out.println("Ingrese el nuevo número:");
                unNumero=scn.nextDouble();
                resultado=dividir(resultado,unNumero);
            }
            else if ((operacion.toLowerCase().equals("multiplicar"))&&(contador==0)){
                System.out.println("Ingrese los 2 valores:");
                unNumero=scn.nextDouble();
                otroNumero=scn.nextDouble();
                resultado=multiplicar(unNumero,otroNumero);
                contador++;
            } else if(operacion.toLowerCase().equals("multiplicar")){
                System.out.println("Ingrese el nuevo número:");
                unNumero=scn.nextDouble();
                resultado=multiplicar(resultado,unNumero);
            }
            else{//si el usuario selecciona una operacion no existente
                System.out.println("Operación desconocida");
                System.out.println("Intente nuevamente");
            }
            verResultado();
            verMenu();
            System.out.println("Elija la operación que desea realizar:");
            operacion=scn.next();
            if(operacion.toLowerCase().equals("salir")){
                salir();
            }
        }


    }
    public double sumar(double unNumero, double otroNumero){
        resultado=unNumero+otroNumero;
        return resultado;
    }
    public double restar(double unNumero, double otroNumero){
        resultado=unNumero-otroNumero;
        return resultado;
    }
    public double multiplicar(double unNumero, double otroNumero){
        resultado=unNumero*otroNumero;
        return resultado;
    }
    public double dividir(double unNumero, double otroNumero){
        resultado=unNumero/otroNumero;
        return resultado;
    }

    public void limpiar(){
        resultado=0;
        contador=0;
        System.out.println("Se han limpiado la memoria con éxito!");
    }

    public void salir(){
        bandera=false;
        System.out.println("Proceso finalizado con éxito!");
        System.out.println("Gracias por utilizar nuestra Calculadora.");
    }
    public void verResultado(){
        System.out.println("El resultado es: "+resultado);
    }

}
