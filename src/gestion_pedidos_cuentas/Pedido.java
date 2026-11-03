package gestion_pedidos_cuentas;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String estadoPedido;
    private int idPedido;
    private Mesa mesa;
    private Cliente cliente;
    private List<Detalle_Pedido> detalles;
    private double IVA= 0.15;

    public Pedido(int idPedido, Mesa mesa, Cliente cliente) {
        this.estadoPedido = "PENDIENTE";
        this.idPedido= idPedido;
        this.mesa = mesa;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        
        this.mesa.setOcupado(true);
    }
    
    
    // Se añade un producto al Array
    public void agregarItem(Detalle_Pedido Producto) {
        this.detalles.add(Producto);
    }
    
    // Se elimina algun producto
    public void quitarItem(Detalle_Pedido Producto) {
        this.detalles.remove(Producto);
    }
    
    // Se calcula el subtotal usando el Array
    
    public double calcularSubtotal(){
        double subtotal = 0;
        for(Detalle_Pedido d: detalles){
            subtotal += d.calcularSubtotalPorProducto();
        }
        return subtotal;
    }
    // Calculamoas total con impuestos
    
    public double calcularTotal(){
        double subtotal = calcularSubtotal();
        double impuesto = subtotal * IVA;
        return subtotal + impuesto;
    }
    
    // 

    public int getIdPedido() {
        return idPedido;
    }
    
    

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estado) {
        this.estadoPedido = estado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Detalle_Pedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle_Pedido> detalles) {
        this.detalles = detalles;
    }
 
}