package gestion_pedidos_cuentas;

public class Detalle_Pedido {
    private Menu producto; 
    private int cantidad;
   

    public Detalle_Pedido(Menu producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
  
 
    }

    public void setCantidad(int cantidad) {
        if (cantidad > 0){
            this.cantidad = cantidad;
        }
        
    }
    

    public double calcularSubtotalPorProducto() {
        return producto.getPrecioBase() * cantidad;
    }

    public Menu getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    
    
    
}
