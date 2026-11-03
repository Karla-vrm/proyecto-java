package gestion_pedidos_cuentas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GESTION_PEDIDOS_CUENTAS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal = 0;
        
        //Lista de Mesas:
        List<Mesa> listaMesas = new ArrayList<>();
        //Lista Menú:
        List<Menu> listaMenu = new ArrayList<>();
        //Lista Pedidos:
        List<Pedido> listaPedidos = new ArrayList<>();
        

        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE RESTAURANTE ===");
            System.out.println("1. Gestión del Menú"); // Muestra el Menu.
            System.out.println("2. Gestión de Mesas"); // Permite crear mesas y consultar sus estados.
            System.out.println("3. Gestión de Pedidos"); 
            System.out.println("4. Facturación y Cuentas");
            System.out.println("5. Consultas y Reportes Básicos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            if (scanner.hasNextInt()) {
                opcionPrincipal = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcionPrincipal) {
                case 1:
                    menuGestionMenu(scanner, listaMenu);
                    break;
                case 2:
                    menuGestionMesas(scanner, listaMesas);
                    break;
                case 3:
                    menuGestionPedidos(scanner, listaMesas, listaPedidos, listaMenu);
                    break;
                case 4:
                    menuFacturacion(scanner);
                    break;
                case 5:
                    menuConsultasReportes(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcionPrincipal != 6);

        scanner.close();
    }

    
    public static void menuGestionMenu(Scanner scanner, List<Menu> listaMenu) {
        int opcion;
        do {
            System.out.println("\n--- Submenú 1: Gestión del Menú ---");
            System.out.println("1. Registrar nuevo Plato");
            System.out.println("2. Registrar nueva Bebida");
            System.out.println("3. Registrar nuevo Postre");
            System.out.println("4. Listar elementos del menú");
            System.out.println("5. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR PLATO---");

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Precio Base: ");
                    double precioBase = Double.parseDouble(scanner.nextLine());
                    
                    System.out.print("Ingrese que tipo (Entrada/Fuerte): ");
                    String tipoPlato =scanner.nextLine();
                    
                    Plato nuevoPlato = new Plato(tipoPlato, nombre, precioBase);
                    
                    listaMenu.add(nuevoPlato);
                    
                    System.out.println("[Lógica] Registrando nuevo plato...");
   
                    break;
                case 2:
                    System.out.println("\n--- REGISTRAR BEBIDA---");

                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();

                    System.out.print("Precio Base: ");
                    precioBase = Double.parseDouble(scanner.nextLine());
                    
                    System.out.print("Ingrese el tamaño de la Bebida: ");
                    String tamano =scanner.nextLine();
                    
                    Bebida nuevaBebida = new Bebida(nombre, precioBase, tamano);
                    
                    listaMenu.add(nuevaBebida);
                    System.out.println("[Lógica] Registrando nueva bebida...");
                    break;
                case 3:
                    System.out.println("\n--- REGISTRAR POSTRE---");

                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();

                    System.out.print("Precio Base: ");
                    precioBase = Double.parseDouble(scanner.nextLine());
                    
                    System.out.print("Ingrese el tipo de postre (frío/caliente): ");
                    String tipoPostre =scanner.nextLine();
                    
                    Postre nuevoPostre = new Postre(nombre, precioBase, tipoPostre);
                    
                    listaMenu.add(nuevoPostre);
                    System.out.println("[Lógica] Registrando nuevo postre...");
                    break;
                case 4:
                    System.out.println("\n--- MENÚ DEL RESTAURANTE ---");
                    if(listaMenu.isEmpty()){
                        System.out.println("El menú esta vacío");
                    }else{
                        System.out.println("[Lógica] Listando elementos del menú...");
                        for(Menu p: listaMenu){
                            p.mostrarInformacion();
                        }
                    }
  
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    
    public static void menuGestionMesas(Scanner scanner, List<Mesa> listaMesas) {
        int opcion;
        do {
            System.out.println("\n--- Submenú 2: Gestión de Mesas ---");
            System.out.println("1. Registrar nueva mesa (Número y capacidad)");
            System.out.println("2. Ver estado de todas las mesas");
            System.out.println("3. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR MESA---");

                    System.out.print("Numero de Mesa: ");
                    String id = scanner.nextLine();

                    System.out.print("Capacidad: ");
                    int capacidad = Integer.parseInt(scanner.nextLine());
                    
                    Mesa nuevaMesa = new Mesa(id, capacidad);
                    
                    listaMesas.add(nuevaMesa);
                    
                    System.out.println("[Lógica] Registrando nueva mesa...");
                    break;
                case 2:
                    System.out.println("\n--- LISTADO DE MESAS ---");
 
                    if(listaMesas.isEmpty()){
                        System.out.println("No hay mesas registradas! ");
                    }else{
                        System.out.println("[Lógica] Mostrando estado de las mesas...");
                        for(Mesa m: listaMesas){
                            if(m.isOcupada()){
                                System.out.println("Mesa "+ m.getId()+": OCUPADA" );
                            }else{
                                System.out.println("Mesa "+ m.getId()+": LIBRE");
                            }
                        }
                    }
                    
  
                    break;
                case 3:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }

    
    public static void menuGestionPedidos(Scanner scanner, List<Mesa> listaMesas, List<Pedido> listaPedidos, List<Menu> listaMenu) {
        int opcion;
        do {
            System.out.println("\n--- Submenú 3: Gestión de Pedidos ---");
            System.out.println("1. Crear nuevo pedido para una mesa");
            System.out.println("2. Agregar ítem (plato/bebida/postre) a un pedido existente");
            System.out.println("3. Cambiar estado de un pedido (Pendiente -> En cocina -> Servido)");
            System.out.println("4. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- CREAR NUEVO PEDIDO ---");
                    
                    System.out.println("--- Datos del Cliente ---");
                    System.out.print("Cédula: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    
                    Cliente clienteActual = new Cliente(cedula, nombre, false, telefono);
                    
                    // ASIGNAMOS UNA MESA
                    System.out.print("Ingrese el numero de Mesa que desea ocupar: ");
                    String idMesa = scanner.nextLine();

                    Mesa mesaEncontrada = null;
                    
                    for (Mesa m: listaMesas){
                        if(m.getId().equals(idMesa)){
                            mesaEncontrada = m;
                            break;
                        }
                    }
                    
                    if(mesaEncontrada != null){
                        
                        int nuevoIdPedido = listaPedidos.size()+1;
                        Pedido nuevoPedido = new Pedido(nuevoIdPedido, mesaEncontrada, clienteActual);
                        
                        boolean pidiendo = true;
                        System.out.println("[Lógica] Creando nuevo pedido...");
                        scanner.nextLine();
                        while(pidiendo){
                            System.out.println("--- Ingresar Producto ---");
                            System.out.println("0. Terminar de pedir");
            
                            System.out.print("Seleccione un producto: ");
                            int opcProducto = scanner.nextInt();
                            scanner.nextLine();
                            if (opcProducto == 0) {
                                pidiendo = false;
                            } else if (opcProducto > 0 && opcProducto <= listaMenu.size()) {
                                Menu productoElegido = listaMenu.get(opcProducto - 1);
                
                                System.out.print("Ingrese cantidad: ");
                                int cantidad = scanner.nextInt();
                                scanner.nextLine();
                                
                                Detalle_Pedido nuevoDetalle = new Detalle_Pedido(productoElegido, cantidad);
                                nuevoPedido.agregarItem(nuevoDetalle);
                            } else {
                                System.out.println("Producto inválido.");
                            }
                        }
                    } else {
                        System.out.println("Error: Mesa no válida o ya está ocupada.");
                    }    
                    break;
                    
                case 2:
                    System.out.println("\n--- AGREGAR ÍTEM A UN PEDIDO EXISTENTE ---");
                    
                    if (listaPedidos.isEmpty()) {
                        System.out.println("No hay pedidos activos en el sistema.");
                        break;
                    }
                    
                    System.out.print("Ingrese el ID del Pedido a modificar: ");
                    int idBuscar = scanner.nextInt();
                    scanner.nextLine(); 
    
                    Pedido pedidoBuscado = null;
                    for (Pedido p : listaPedidos) {
                        if (p.getIdPedido() == idBuscar) {
                            pedidoBuscado = p;
                            break;
                        }
                    }
                    
                    System.out.print("Seleccione el producto a agregar: ");
                    int opcProducto = scanner.nextInt();
                    scanner.nextLine();
        
                    if (opcProducto > 0 && opcProducto <= listaMenu.size()) {
                        Menu productoElegido = listaMenu.get(opcProducto - 1);
            
                        System.out.print("Cantidad: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();
                        
                        Detalle_Pedido nuevoDetalle = new Detalle_Pedido(productoElegido, cantidad);
                        pedidoBuscado.agregarItem(nuevoDetalle);
                        
                        System.out.println("[Lógica] Agregando ítem al pedido...");
                    }else {
                        System.out.println("Producto no válido.");
                    }
  
                    break;
                case 3:
                    System.out.println("\n--- CAMBIAR ESTADO DEL PEDIDO ---");
                    if (listaPedidos.isEmpty()) {
                        System.out.println("No hay pedidos en el sistema.");
                        break;
                    }
                    
                    System.out.print("\nIngrese el ID del Pedido a modificar: ");
                    int idPedidoEstado = scanner.nextInt();
                    scanner.nextLine();
                    
                    Pedido pedidoEstado = null;
                    for (Pedido p : listaPedidos) {
                        if (p.getIdPedido() == idPedidoEstado) {
                            pedidoEstado = p;
                            break;
                        }
                    }
                    
                    if (pedidoEstado != null) {
                        System.out.println("\nSeleccione el nuevo estado:");
                        System.out.println("1. PENDIENTE");
                        System.out.println("2. EN COCINA");
                        System.out.println("3. SERVIDO");
                        System.out.print("Opción: ");
                        int opEstado = scanner.nextInt();
                        scanner.nextLine();
                         switch (opEstado) {
                            case 1:
                                pedidoEstado.setEstadoPedido("PENDIENTE");
                                System.out.println(">> Estado actualizado a: PENDIENTE");
                                break;
                            case 2:
                                pedidoEstado.setEstadoPedido("EN COCINA");
                                System.out.println(">> Estado actualizado a: EN COCINA");
                                break;
                            case 3:
                                pedidoEstado.setEstadoPedido("SERVIDO");
                                System.out.println(">> Estado actualizado a: SERVIDO");
                                break;
                            default:
                                System.out.println("Opción de estado inválida.");
                                break;
                        }
                    }else {
                        System.out.println("Error: Pedido no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }

    
    public static void menuFacturacion(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Submenú 4: Facturación y Cuentas ---");
            System.out.println("1. Generar pre-cuenta de una mesa (Subtotal e impuestos)");
            System.out.println("2. Aplicar descuento a la cuenta");
            System.out.println("3. Procesar pago y finalizar pedido (Servido -> Pagado)");
            System.out.println("4. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("[Lógica] Generando pre-cuenta...");
                    break;
                case 2:
                    System.out.println("[Lógica] Aplicando descuento...");
                    break;
                case 3:
                    System.out.println("[Lógica] Procesando pago...");
                    break;
                case 4:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }

    
    public static void menuConsultasReportes(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Submenú 5: Consultas y Reportes Básicos ---");
            System.out.println("1. Ver listado general del menú");
            System.out.println("2. Total dinero recaudado");
            System.out.println("3. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("[Lógica] Mostrando listado del menú...");
                    break;
                case 2:
                    System.out.println("[Lógica] Mostrando total de dinero recaudado...");
                    break;
                case 3:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }
}