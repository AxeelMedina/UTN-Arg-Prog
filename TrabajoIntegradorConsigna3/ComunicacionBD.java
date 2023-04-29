import java.sql.*;
import java.util.Scanner;

public class ComunicacionBD {
    private static final String url= "jdbc:mysql://localhost:3306/proyectointegrador";
    private static final String user= "root";
    private static final String password="";
    //private Statement cSQL;
    //private ResultSet sql;

    public ComunicacionBD(){
    }
    public Connection iniciarComunicacion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conex = DriverManager.getConnection(url, user, password);
            return conex;
        } catch (Exception e) {
            System.out.println("Error en iniciarComunicacion. " + e);
        }
        return null;
    }
    public void finalizarComunicacion(Connection conex){
        if (conex != null) {
            try {
                conex.close();
                conex = null;
            } catch (SQLException ex) {
                System.out.println("Error al finalizar. "+ex);
            }
        }
    }
    public ResultSet consultarCuil(long cuil){
        Connection conex=iniciarComunicacion();
        String consulta=String.format("select * from clientes where cuilC=%s", cuil);
        ResultSet sql=null;
        try {
            Statement cSQL = conex.createStatement();
            sql = cSQL.executeQuery(consulta);
            if(sql.next()){
            } else
                sql=null;
        } catch (Exception e) {
            System.out.println("Error en consultar Cuil. " + e);
        }
        finalizarComunicacion(conex);
        return sql;
    }
    public int ultimoIndiceProducto(){
        Connection conex=iniciarComunicacion();
        ResultSet rango=null;
        int nro=0;
        try {
            Statement cSQL = conex.createStatement();
            rango=cSQL.executeQuery("select count(*) from productos ");
            while(rango.next()){
                //System.out.println("El último índice es: "+rango.getInt(1));
                nro=rango.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error en ultimoIndiceProducto. " + e);
        }
        finalizarComunicacion(conex);
        return nro;
    }
    public int validarProducto(int codigo, int cantidad){
        Connection conex=iniciarComunicacion();
        String consulta=String.format("select * from productos where idP=%s", codigo);
        //String consulta2="select count(*) from productos ";
        ResultSet sql=null;
        try {
            Statement cSQL = conex.createStatement();
            sql = cSQL.executeQuery(consulta);
            while (sql.next()) {
                int nuevaCantidad=sql.getInt(5)-cantidad;
                if(sql.getInt(5)==0){
                    System.out.println("Lo lamentamos, pero no quedan unidades del producto.");
                    //finalizarComunicacion(conex);
                    return 0;
                } else if (nuevaCantidad<0) {
                    System.out.println("No hay stock suficiente, quedan "+sql.getInt(5)+" unidades.");
                    System.out.println("Por favor elija una cantidad inferior.");
                    //finalizarComunicacion(conex);
                    return 1;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en validarProducto. "+e);
        }
        finalizarComunicacion(conex);
        return 2;
    }
    public Producto dameProducto(int codigo, int cantidad){
        Connection conex=iniciarComunicacion();
        String consulta=String.format("select * from productos where idP=%s", codigo);
        Producto p=null;
        ResultSet sql=null;

        try {
            Statement cSQL = conex.createStatement();
            Statement cSQL2 = conex.createStatement();
            sql = cSQL.executeQuery(consulta);
            while (sql.next()) {
                    p=new Producto(sql.getInt(1),sql.getString(2),sql.getString(3),
                            sql.getDouble(4),sql.getInt(5));
                    int nuevaCantidad=sql.getInt(5)-cantidad;
                    consulta="update productos set stockP="+nuevaCantidad+" where idP="+codigo;
                    cSQL2.executeUpdate(consulta);
            }
        } catch (SQLException e) {
            System.out.println("Error en dameProducto. "+e);
        }
        finalizarComunicacion(conex);
        return p;
    }
    public void dameCliente(){}
    public void agregarCarrito(Cliente c1, Carrito carro){
        Connection conex=iniciarComunicacion();
        String consulta="insert into carrito (idCA,idC,montoCA,montoDesCA,fechaCA) values (idCA,?,?,?,?)";
        PreparedStatement sqlUpd= null;
        try {
            sqlUpd = conex.prepareStatement(consulta);
            sqlUpd.setInt(1,c1.dameCodigo());
            sqlUpd.setDouble(2,carro.dameMontoTotal());
            sqlUpd.setDouble(3,carro.dameMontoConDescuento());
            sqlUpd.setString(4,carro.dameDia().toString());
            sqlUpd.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en insertarCarrito"+e);
        }
        finalizarComunicacion(conex);
    }

    public long crearClienteBD(){
        Connection conex=iniciarComunicacion();
        String nomC=null;
        String direC=null;
        String aux=null;
        String consulta="insert into clientes (idC,cuilC,nomC,direC) values (idC,?,?,?)";
        Scanner scn=new Scanner(System.in);
        System.out.println("Ingrese su CUIL/CUIT sin guiones ni espacios:");
        long cuilC=scn.nextLong();
        aux=scn.nextLine();
        System.out.println("Ingrese su nombre y apellido: ");
        nomC=scn.nextLine();
        System.out.println("Ingrese su dirección: ");
        direC=scn.nextLine();
        PreparedStatement sqlUpd= null;
        try {
            sqlUpd = conex.prepareStatement(consulta);
            sqlUpd.setLong(1,cuilC);
            sqlUpd.setString(2,nomC);
            sqlUpd.setString(3,direC);
            sqlUpd.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en crearClienteBD. "+e);
        }
        finalizarComunicacion(conex);
        return cuilC;
    }
    public Cliente crearCliente(long cuil){
        Connection conex= iniciarComunicacion();
        String consulta = String.format("select * from clientes where cuilC=%s", cuil);
        Cliente c1=null;
        try{
            Statement cSQL= conex.createStatement();
            ResultSet sql = cSQL.executeQuery(consulta);
            while (sql.next()) {
                c1 = new Cliente(sql.getInt(1), sql.getLong(2), sql.getString(3), sql.getString(4));
                c1.mostrarPersona();
            }
        }catch (Exception e){
            System.out.println("Error en crearCliente. "+e);
        }
        finalizarComunicacion(conex);
        return c1;
    }
    public void dameCarritosPorIdC(Cliente c1){
        Connection conex=iniciarComunicacion();
        String consulta = String.format("select * from carrito where idC=%s", c1.dameCodigo());
        Statement cSQL=null;
        try {
            cSQL=conex.createStatement();
            ResultSet mostrar=cSQL.executeQuery(consulta);
            System.out.println("fecha\t\tID\tMonto\tMonto con desc");
            while(mostrar.next()){
                System.out.println(mostrar.getString(5)+"\t"+mostrar.getInt(1)+"\t"+
                        mostrar.getBigDecimal(3)+"\t"+mostrar.getBigDecimal(4));
            }
        } catch (Exception e){
            System.out.println("Error en dameCarritosPorIdC. "+e);
        }

        finalizarComunicacion(conex);
    }
}
