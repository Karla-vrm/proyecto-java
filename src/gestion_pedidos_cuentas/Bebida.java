package gestion_pedidos_cuentas;

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

    public String getTamano() {
        return tamano;
    }
    
    
    

    
    }


    
    
    



