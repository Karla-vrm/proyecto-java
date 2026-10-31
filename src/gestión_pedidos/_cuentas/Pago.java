
package gestión_pedidos._cuentas;

public class Pago {
    private String metodoPago;
    private double monto;
    private Pedido pedido; 

    public Pago(String metodoPago, double monto, Pedido pedido) {
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.pedido = pedido;
    }

    public boolean confirmarPago() {
       
        return true;
    }
    
}
