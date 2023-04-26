package paqueteDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionDB {
    public static void main(String[] args) {
        try {
            //registrar el driver
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            //crear la conexión
            Connection cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/qatar2022",
                    "root", "LP986a9sAKsLl96");
            //crear las consultas
            Statement cSQL= cx.createStatement();

            //insertar empleado en el dpto logística
            String insertar="insert into empleados (idE, dniE, nomE, apeE, nacE, dpto) values " +
                    "(ide, \"24865076\", \"Esteban\", \"Quito\", \"Argentina\", \"Logística\")";
            cSQL.executeUpdate(insertar);

            //modificar la nacionalidad de un empleado
            String modificar="update empleados set nacE=\"Croacia\" where idE=8 ";
            cSQL.executeUpdate(modificar);

            //eliminar un departamento
            String eliminar="delete from departamentos where idD=1";

            //mostrar empleados de logística
            String consulta="select * from empleados where dpto =\"Logística\"";
            ResultSet mostrar=cSQL.executeQuery(consulta);
            System.out.println("ID\tDocumento\tNombre\tApellido\tNacionalidad\tDepartamento");
            while(mostrar.next()){
                System.out.println(mostrar.getInt(1)+"\t"+mostrar.getString(2)+"\t"+
                        mostrar.getString(3)+"\t\t"+mostrar.getString(4)+"\t"+
                        mostrar.getString(5)+"\t"+mostrar.getString(6));
            }

            //mostrar dptos ordenados alfabeticamente
            String consulta2="select * from departamentos order by nomD asc";
            ResultSet mostrar2=cSQL.executeQuery(consulta2);
            System.out.println("ID\tDepartamento\tDescripcion\tPresupuesto");
            while(mostrar2.next()){
                System.out.println(mostrar2.getInt(1)+"\t"+mostrar2.getString(2)+"\t"+
                        mostrar2.getString(3)+"\t"+mostrar2.getBigDecimal(4));
            }

        } catch (Exception e) {
            System.out.println("Error de conexion "+e);
        }

    }
}