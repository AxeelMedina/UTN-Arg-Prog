package PrimerPaquete;

public class ClasePrincipal {
    public static void main(String[] args) {
        //Ejercicio 1.a
        int numeroInicio = 5;
        int numeroFin = 14;

        int aux1=numeroInicio;
        while(aux1<=numeroFin){
            System.out.print(aux1+", ");
            aux1++;
        }
        System.out.println();

        //Ejercicio 1.b
        System.out.println("Los números pares son:");
        for(int i=numeroInicio; i<=numeroFin; i++){
            if(i%2==0)
                System.out.print(i+", ");
        }
        System.out.println();

        //Ejercicio 1.c
        boolean parImpar=false; //si es true => imprime pares, sino impares.
        if(parImpar){
            System.out.println("Los números pares son:");
            for(int i=numeroInicio; i<=numeroFin; i++){
                if(i%2==0)
                    System.out.print(i+", ");
            }
        }else{
            System.out.println("Los números impares son:");
            for(int i=numeroInicio; i<=numeroFin; i++){
                if(i%2!=0)
                    System.out.print(i+", ");
            }
        }
        System.out.println();

        //Ejercicio 1.d
        System.out.println("Los números pares, en orden invertido, son:");
        for(int i=numeroFin; i>=numeroInicio; i--){
            if(i%2==0)
                System.out.print(i+", ");
        }
        System.out.println();

        //Ejercicio 2.d
        int ingresosMensuales=489083;
        int cantidadVehiculos=5;
        int cantidadInmuebles=3;
        boolean embarcacion=false;
        boolean aeronaveLujo=false;
        boolean activosSocietarios=true;

        if((ingresosMensuales>=489083)&&(cantidadVehiculos>=5)&&(cantidadInmuebles>=3)&&((embarcacion)||(aeronaveLujo)||(activosSocietarios))){
            System.out.println("Pertenece al segmentos de ingresos altos.");
        }else {
            System.out.println("No pertenece al segmentos de ingresos altos.");
        }
    }
}
