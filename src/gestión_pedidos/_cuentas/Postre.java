package gestión_pedidos._cuentas;


public class Postre extends Menu {
    private double precio; 

    public Postre(String nombre, double precioBase, double precio) {
        super(nombre, precioBase); 
        this.precio = precio;
    }

    public double descuento() {
       
        return 0.0; 
    }

    public double subtotal() {
        
        return this.precio; 
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Postre: " + nombre + " | Precio: $" + precio);
    }
}