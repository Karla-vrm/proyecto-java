
package gestion_pedidos_cuentas;

public interface Pago {
   boolean procesarPago(Pedido pedido); 
    
    String getTipoPago();
    
    
}
