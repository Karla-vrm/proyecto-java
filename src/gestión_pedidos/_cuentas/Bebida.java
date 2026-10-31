package gestión_pedidos._cuentas;


public class Bebida extends Menu {
    private String tamano;

    public Bebida(String nombre, double precioBase, String tamano) {
        super(nombre, precioBase); 
        this.tamano = tamano;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Bebida: " + getNombre() + " | Tamaño: " + tamano + " | Precio: $" + getPrecioBase());
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getTamano() {
        return tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    
    
    
}


