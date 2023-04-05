import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String nombres=pedirNombres();
        Path ruta= Paths.get("D:\\Curso Java\\Guia-4-3\\src\\archivo.txt");
        escribirNombres(nombres,ruta);

    }
    private static String pedirNombres(){
        Scanner nombre= new Scanner(System.in);
        System.out.println("Escriba los nombres a continuación: ");
        String nombres=nombre.nextLine();
        return nombres;
    }

    private static void escribirNombres(String nombres, Path ruta) throws IOException {
        Files.write(ruta,nombres.getBytes());
    }

}