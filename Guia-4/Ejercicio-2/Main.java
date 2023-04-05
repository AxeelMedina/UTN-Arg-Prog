import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File archivo= new File("D:\\Curso Java\\Guia4-2\\src\\archivo.txt");
        char op='m';//s es suma, m es multiplicación
        int resultado=operacion(archivo,op);
        System.out.println(resultado);
    }

    private static int operacion(File ruta, char op) throws FileNotFoundException {
        Scanner datos= new Scanner(ruta);
        int resultadoSuma=0;
        int resultadoMult=1;
        if(op=='s'){
            while(datos.hasNextInt()){
                resultadoSuma+=datos.nextInt();
            }
            return resultadoSuma;
        } else if(op=='m'){
            while(datos.hasNextInt()){
                resultadoMult*=datos.nextInt();
            }
            return resultadoMult;
        }
        return 0; //Por si acaso
    }
}

