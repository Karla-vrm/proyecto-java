package gestion_pedidos_cuentas;


public class Cliente {
    private String cedula;
    private String nombre;
    private boolean afiliado;
    private String telefono;

    public Cliente(String cedula, String nombre, boolean afiliado, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.afiliado = afiliado;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAfiliado() {
        return afiliado;
    }

    public void setAfiliado(boolean afiliado) {
        this.afiliado = afiliado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
    

