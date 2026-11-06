package gestion_pedidos_cuentas;

public class Mesa {
    private String id;
    private int capacidad;
    private boolean ocupado;

    public Mesa(String id, int capacidad) {
        this.id = id;
        this.capacidad = capacidad;
        this.ocupado = false; // Inicia libre
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacidad() {
 
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if(capacidad > 0){
            this.capacidad = capacidad;
        }

    }

    public boolean isOcupada(){
        return ocupado;
    }
    
    public void setOcupado(boolean ocupado){
        this.ocupado = ocupado;
    }
    
}
