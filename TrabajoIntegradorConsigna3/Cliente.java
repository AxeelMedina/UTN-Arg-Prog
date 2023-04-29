public class Cliente {
    private int codigo;
    private long cuil;
    private String nombre;
    private String dire;

    //Metodo constructor
    public Cliente(int codigo,long cuil, String nombre, String dire) {//METODO CONSTRUCCTOR DE LA CLASE PERSONA
        this.codigo=codigo;
        this.cuil=cuil;
        this.nombre=nombre;
        this.dire = dire;
    }
    public long dameCuil() {
        return cuil;
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
        System.out.println("-----------------------------------");
        System.out.println("Ficha personal de cliente:");
        System.out.println("Código persona: "+codigo);
        System.out.println("CUIL: "+cuil);
        System.out.println("Nombre: "+nombre);
        System.out.println("Dirección: "+dire);
        System.out.println("-----------------------------------");
    }

}
