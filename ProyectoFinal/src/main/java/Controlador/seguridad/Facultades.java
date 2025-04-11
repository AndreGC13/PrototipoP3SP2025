package Controlador.seguridad;



public class Facultades {
    private int codigo_facultad;
    private String nombre_facultad;
    private String estatus_facultad;

    public Facultades() {
    }

    public Facultades(int codigo_facultad) {
        this.codigo_facultad = codigo_facultad;
    }
    
    public Facultades(String nombre_facultad, String estatus_facultad) {
        this.nombre_facultad = nombre_facultad;
        this.estatus_facultad = estatus_facultad;
    }
    
    public Facultades(int codigo_facultad, String nombre_facultad, String estatus_facultad) {
        this.codigo_facultad = codigo_facultad;
        this.nombre_facultad = nombre_facultad;
        this.estatus_facultad = estatus_facultad;
    }
    

    public int getcodigo_facultad() {
        return codigo_facultad;
    }

    public void setcodigo_facultad(int codigo_facultad) {
        this.codigo_facultad = codigo_facultad;
    }

    public String getnombre_facultad() {
        return nombre_facultad;
    }

    public void setnombre_facultad(String nombre_facultad) {
        this.nombre_facultad = nombre_facultad;
    }

    public String getestatus_facultad() {
        return estatus_facultad;
    }

    public void setestatus_facultad(String estatus_facultad) {
        this.estatus_facultad = estatus_facultad;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo_facultad=" + codigo_facultad + ", nombre_facultad=" + nombre_facultad + ", estatus_facultad=" + estatus_facultad + '}';
    }

    public void setid_Usuario(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
