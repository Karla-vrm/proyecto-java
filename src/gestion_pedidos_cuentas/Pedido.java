package gestion_pedidos_cuentas;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String estadoPedido;
    private int idPedido;
    private Mesa mesa;
    private Cliente cliente;
    private List<Detalle_Pedido> detalles;
    private double IVA = 0.15;
    private double porcentajeDescuento = 0.0; 

    public Pedido(int idPedido, Mesa mesa, Cliente cliente) {
        this.estadoPedido = "PENDIENTE";
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        this.mesa.setOcupado(true);
    }
    
    public void agregarItem(Detalle_Pedido Producto) {
        this.detalles.add(Producto);
    }
    
    public void quitarItem(Detalle_Pedido Producto) {
        this.detalles.remove(Producto);
    }
    
    public double calcularSubtotal(){
        double subtotal = 0;
        for(Detalle_Pedido d: detalles){
            subtotal += d.calcularSubtotalPorProducto();
        }
        return subtotal;
    }
    
    
    public double calcularTotal(){
        double subtotal = calcularSubtotal();
        double descuento = subtotal * (porcentajeDescuento / 100.0);
        double subtotalConDesc = subtotal - descuento;
        double impuesto = subtotalConDesc * IVA;
        return subtotalConDesc + impuesto;
    }

    // NUEVO: Getters y Setters para el descuento
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

   
}