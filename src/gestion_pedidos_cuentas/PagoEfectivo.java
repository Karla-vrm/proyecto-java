package gestion_pedidos_cuentas;
import java.util.Scanner;
public class PagoEfectivo implements Pago {

    @Override
    public boolean procesarPago(Pedido pedido) {
        Scanner scanner = new Scanner(System.in);
        double total = pedido.calcularTotal();
        
        System.out.printf("Total a cobrar: $%.2f\n", total);
        System.out.print("Ingrese con cuánto paga el cliente: $");
        double recibido = scanner.nextDouble();
        scanner.nextLine();
        
        if (recibido > total) {
            System.out.printf("Vuelto: $%.2f\n", (recibido - total));
            return true;
        } else {
            System.out.println("Error: Dinero insuficiente.");
            return false;
        }
    }

    @Override
    public String getTipoPago() {
        return "Efectivo";
    }
    
    
    
    
}
