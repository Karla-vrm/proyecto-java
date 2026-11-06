package gestion_pedidos_cuentas;


public class Postre extends Menu {
    private String tipoPostre; 

    public Postre(String nombre, double precioBase, String tipoPostre) {
        super(nombre, precioBase); 
        this.tipoPostre = tipoPostre;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Postre: " + getNombre() + " | Tipo:" + tipoPostre + " | Precio: $" + getPrecioBase());
    }
}