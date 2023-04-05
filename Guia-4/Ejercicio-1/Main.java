import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Ejercicio 1.a.
        int vector[]={10,11,12};
        char op='d'; //a es ascendente, d es descendente
        int vectorOrdenado[]=ordenar(vector,op);
        for (int i=0; i< vectorOrdenado.length; i++ ) {
            System.out.print(vectorOrdenado[i] + "-");
        }

        //Ejercicio 1.b.
        char op2;
        int vector2[]=new int[3];
        Scanner scn = new Scanner(System.in);
        System.out.println("\nIngrese un número entero y presione \"enter\" hasta un total de 3 nùmeros:");
        vector2[0]= scn.nextInt();
        vector2[1]= scn.nextInt();
        vector2[2]= scn.nextInt();
        System.out.println("Ahora escriba \"ascendente\" o \"descendente\":");
        String decision=scn.next();
        decision=decision.toLowerCase();
        if(decision.equals("ascendente")){
            op2='a';
        } else{
            op2='d';
        }
        int vectorOrdenado2[]=ordenar(vector2,op2);
        for (int i=0; i< vectorOrdenado2.length; i++ ) {
            System.out.print(vectorOrdenado2[i] + "-");
        }

        //Ejercicio 1.c.
        char op3;
        int vector3[]=new int[3];
        vector3[0]=10;
        vector3[2]=100;
        System.out.println("\nIngrese un número entero y presione \"enter\": ");
        vector3[1]= scn.nextInt();
        System.out.println("Ahora escriba \"ascendente\" o \"descendente\":");
        String decision2=scn.next();
        decision2=decision2.toLowerCase();
        if(decision2.equals("ascendente")){
            op3='a';
        } else{
            op3='d';
        }
        int vectorOrdenado3[]=ordenar(vector3,op3);
        for (int i=0; i< vectorOrdenado3.length; i++ ) {
            System.out.print(vectorOrdenado3[i] + "-");
        }

    }

    private static int[] ordenar(int vector[],char op){
        int num1=0, num2=0,num3=0, aux1=0, aux2=0, mayor=0;
        num1 = vector[0];
        num2 = vector[1];
        num3 = vector[2];
        if ((num1 > num2) && (num1 > num3)) {
            mayor=num1;
            if (num2 > num3) {
                aux1=num2;
                aux2=num3;
            }else {
                aux1=num3;
                aux2=num2;
            }
        } else{
            if ((num2 > num3) && (num2 > num1)) {
                mayor=num2;
                if (num1 > num3) {
                    aux1=num1;
                    aux2=num3;
                }else {
                    aux1=num3;
                    aux2=num1;
                }
            }else {
                mayor=num3;
                if (num2 > num1) {
                    aux1=num2;
                    aux2=num1;
                }else {
                    aux1=num1;
                    aux2=num2;
                }
            }
        }
        int vecOrdenado [] = new int[3];
        if (op == 'd') {
            vecOrdenado[0]=mayor;
            vecOrdenado[1]=aux1;
            vecOrdenado[2]=aux2;
        }else {
            vecOrdenado[0]=aux2;
            vecOrdenado[1]=aux1;
            vecOrdenado[2]=mayor;
        }
        return vecOrdenado;

    }
}