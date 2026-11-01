package gestion_pedidos_cuentas;

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

    public void setNombre(String nombre) {
        if (nombre != null){
            this.nombre = nombre;
        }
        
    }

    public void setPrecioBase(double precioBase) {
          if (precioBase >0 ){
            this.precioBase = precioBase;
        }
        
    }
    
    
    
    public abstract void mostrarInformacion();
    
}
