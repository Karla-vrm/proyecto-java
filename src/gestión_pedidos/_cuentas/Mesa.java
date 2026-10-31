package gestión_pedidos._cuentas;


public class Mesa {
    private String id;
    private int capacidad;
    private String estado;

    public Mesa(String id, int capacidad, String estado) {
        this.id = id;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setNumero(String id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
