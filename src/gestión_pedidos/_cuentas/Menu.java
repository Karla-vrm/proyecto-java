package gestión_pedidos._cuentas;

public abstract class Menu {
    private String nombre;
    private double precioBase;

    public Menu(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }
    
    
    
    public abstract void mostrarInformacion();
    
    
 
}
