public class Cliente {
    private int codigo;
    private int dni;
    private String nombre;
    private String dire;

    //Metodo constructor
    public Cliente(int codigo,int dni, String nombre, String dire) {//METODO CONSTRUCCTOR DE LA CLASE PERSONA
        this.codigo=codigo;
        this.dni=dni;
        this.nombre=nombre;
        this.dire = dire;
    }
    public int dameDni() {
        return dni;
    }
    public String dameNombre() {
        return nombre;
    }
    public String dameDire() {
        return dire;
    }
    public int dameCodigo() {
        return codigo;
    }
    public void mostrarPersona() {
        System.out.println("Persona Codigo: "+codigo);
        System.out.println("DNI-Nombre: "+dni+"--"+nombre);
        System.out.println("Dire: "+dire);
    }

}
