public class Main {
    public static void main(String[] args) {
        //Ejercicio 1.a
        char letra='a';
        String frase= "Holaa Mundo, como vaaa?";
        int contador=0;
        int posicion=0;
        String frasePreparada=frase.toLowerCase();
        posicion=frasePreparada.indexOf(letra);

        while (posicion!=-1){
            posicion=frasePreparada.indexOf(letra,posicion+1);
            contador++;
        }
        System.out.println("En la siguiente frase: \n\"" +frase + "\" \nLa cantidad de veces que se encuentra la letra \""+ letra + "\" es: " +contador);

        //Ejercicio 1.b
        boolean orden_asc = false;
        int []vectorA = {0,1,2};
        int num1=0, num2=0,num3=0, aux1=0, aux2=0, mayor=0;
        num1 = vectorA[0];
        num2 = vectorA[1];
        num3 = vectorA[2];
        System.out.println(num1+" " + num2+" " + num3);
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
        System.out.println("El mayor es: "+mayor);
        int vecOrdenado [] = new int[3];
        if (orden_asc) {
            vecOrdenado[0]=mayor;
            vecOrdenado[1]=aux1;
            vecOrdenado[2]=aux2;
        }else {
            vecOrdenado[0]=aux2;
            vecOrdenado[1]=aux1;
            vecOrdenado[2]=mayor;
        }
        for (int i=0; i< vecOrdenado.length; i++ ) {
            System.out.print(vecOrdenado[i] + "-");
        }

        //Ejercicio 1.c
        int vector2[]={0,1,2,3,4,5,6,7,8};
        int numX=2;
        int acumulador=0;
        for(int i=0; i< vector2.length;i++){
            if(vector2[i]>numX){
                acumulador+=vector2[i];
            }
        }
        System.out.println("\nLa suma es: "+acumulador);

        //Ejercicio 2
        String nombres="Axel Juana Pedro Guadalupe Pablo Laura Javier Milagros Carlos Ludmila";
        String vectorDeNombres[]=nombres.split(" ");
        for(String nombre: vectorDeNombres){
            System.out.print(nombre+" ");
        }
    }

}