package gestion_pedidos_cuentas;

public class PagoTarjeta implements Pago{

    @Override
    public boolean procesarPago(Pedido pedido) {
        double total = pedido.calcularTotal();
        System.out.printf("Procesando cobro de $%.2f a la tarjeta...\n", total);
        System.out.println("Transacción aprobada por el banco.");
        return true;
    }

    @Override
    public String getTipoPago() {
         return "Tarjeta";
    }
    
}
