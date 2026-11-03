package gestion_pedidos_cuentas;

public class Plato extends Menu {
    private String tipoPlato;

    public Plato(String tipoPlato, String nombre, double precioBase) {
        super(nombre, precioBase);
        this.tipoPlato = tipoPlato;
    }

    public String getTipoPlato() {
        return tipoPlato;
    }

    public void setTipoPlato(String tipoPlato) {
        if(tipoPlato != null){
            this.tipoPlato = tipoPlato;
        }
        
    }
  

    @Override
    public void mostrarInformacion() {
        System.out.println("Plato: " + getNombre() + " | Tipo: " + tipoPlato+ " | Precio: $" + getPrecioBase());
    }
    
    
}
