package gestión_pedidos._cuentas;


import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String estado;
    private Mesa mesa;
    private Cliente cliente;
    private List<Detalle_Pedido> detalles; 

    public Pedido(String estado, Mesa mesa, Cliente cliente) {
        this.estado = estado;
        this.mesa = mesa;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
    }

    public void agregarItem() {
        this.detalles.add();
    }

    public void quitarItem() {
        this.detalles.remove();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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