
package gestion_pedidos_cuentas;

public class Detalle_Pedido {
    private Menu producto; 
    private int cantidad;
    private boolean servido;
    private double descuento;
    private double iva;
    private double subtotal;
    private double total;

    public Detalle_Pedido(Menu producto, int cantidad, double descuento, double iva) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.servido = false;
        this.descuento = descuento;
        this.iva = iva;
 
    }

    public void calcularTotal() {
        this.subtotal = producto.getPrecioBase() * this.cantidad;
        this.total = (this.subtotal - this.descuento) + this.iva;
    }
    
}
