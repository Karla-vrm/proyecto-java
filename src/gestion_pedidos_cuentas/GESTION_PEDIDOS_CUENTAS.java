package gestion_pedidos_cuentas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GESTION_PEDIDOS_CUENTAS {

   
    static final String LINEA = "==============================================";
    static final String SEPARADOR = "----------------------------------------------";
    static final String PENDIENTE = "PENDIENTE";
    static final String EN_COCINA = "EN COCINA";
    static final String SERVIDO = "SERVIDO";
    static final String PAGADO = "PAGADO";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal;

        List<Mesa> listaMesas = new ArrayList<>();
        List<Menu> listaMenu = new ArrayList<>();
        List<Pedido> listaPedidos = new ArrayList<>();

        do {
            titulo("SISTEMA DE GESTIÓN DE RESTAURANTE");
            System.out.println("  [1] Gestión del Menú");
            System.out.println("  [2] Gestión de Mesas");
            System.out.println("  [3] Gestión de Pedidos");
            System.out.println("  [4] Facturación y Cuentas");
            System.out.println("  [5] Consultas y Reportes Básicos");
            System.out.println("  [0] Salir");
            opcionPrincipal = leerEntero(scanner, "Seleccione una opción: ");

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
                    menuFacturacion(scanner, listaPedidos, listaMesas);
                    break;
                case 5:
                    menuConsultasReportes(scanner, listaMenu, listaPedidos);
                    break;
                case 0:
                    System.out.println("\nSaliendo del sistema... ¡Hasta luego!");
                    break;
                default:
                    error("Opción inválida. Intente de nuevo.");
            }
        } while (opcionPrincipal != 0);

        scanner.close();
    }


    public static void menuGestionMenu(Scanner scanner, List<Menu> listaMenu) {
        int opcion;
        do {
            titulo("GESTIÓN DEL MENÚ");
            System.out.println("  [1] Registrar nuevo Plato");
            System.out.println("  [2] Registrar nueva Bebida");
            System.out.println("  [3] Registrar nuevo Postre");
            System.out.println("  [4] Listar elementos del menú");
            System.out.println("  [0] Regresar al menú principal");
            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1: {
                    System.out.println("\n--- REGISTRAR PLATO ---");
                    String nombre = leerTexto(scanner, "Nombre: ");
                    double precioBase = leerPrecio(scanner, "Precio Base: ");
                    String tipoPlato = leerTexto(scanner, "Tipo (Entrada/Fuerte): ");

                    listaMenu.add(new Plato(tipoPlato, nombre, precioBase));
                    ok("Plato registrado exitosamente.");
                    break;
                }
                case 2: {
                    System.out.println("\n--- REGISTRAR BEBIDA ---");
                    String nombre = leerTexto(scanner, "Nombre: ");
                    double precioBase = leerPrecio(scanner, "Precio Base: ");
                    String tamano = leerTexto(scanner, "Tamaño de la bebida: ");

                    listaMenu.add(new Bebida(nombre, precioBase, tamano));
                    ok("Bebida registrada exitosamente.");
                    break;
                }
                case 3: {
                    System.out.println("\n--- REGISTRAR POSTRE ---");
                    String nombre = leerTexto(scanner, "Nombre: ");
                    double precioBase = leerPrecio(scanner, "Precio Base: ");
                    String tipoPostre = leerTexto(scanner, "Tipo de postre (frío/caliente): ");

                    listaMenu.add(new Postre(nombre, precioBase, tipoPostre));
                    ok("Postre registrado exitosamente.");
                    break;
                }
                case 4:
                    mostrarMenu(listaMenu);
                    break;
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    error("Opción inválida.");
            }
        } while (opcion != 0);
    }


    public static void menuGestionMesas(Scanner scanner, List<Mesa> listaMesas) {
        int opcion;
        do {
            titulo("GESTIÓN DE MESAS");
            System.out.println("  [1] Registrar nueva mesa");
            System.out.println("  [2] Ver estado de todas las mesas");
            System.out.println("  [0] Regresar al menú principal");
            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1: {
                    System.out.println("\n--- REGISTRAR MESA ---");
                    String id = leerTexto(scanner, "Número de Mesa: ");

                    
                    if (buscarMesa(listaMesas, id) != null) {
                        error("Ya existe una mesa con ese número.");
                        break;
                    }

                    int capacidad = leerEntero(scanner, "Capacidad: ");
                    if (capacidad <= 0) {
                        error("La capacidad debe ser mayor que 0.");
                        break;
                    }

                    listaMesas.add(new Mesa(id, capacidad));
                    ok("Mesa registrada exitosamente.");
                    break;
                }
                case 2:
                    System.out.println("\n--- LISTADO DE MESAS ---");
                    if (listaMesas.isEmpty()) {
                        System.out.println("No hay mesas registradas.");
                    } else {
                        System.out.printf("%-10s %-10s%n", "MESA", "ESTADO");
                        System.out.println(SEPARADOR);
                        for (Mesa m : listaMesas) {
                            System.out.printf("%-10s %-10s%n", m.getId(), m.isOcupada() ? "OCUPADA" : "LIBRE");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    error("Opción inválida.");
            }
        } while (opcion != 0);
    }


    public static void menuGestionPedidos(Scanner scanner, List<Mesa> listaMesas, List<Pedido> listaPedidos, List<Menu> listaMenu) {
        int opcion;
        do {
            titulo("GESTIÓN DE PEDIDOS");
            System.out.println("  [1] Crear nuevo pedido para una mesa");
            System.out.println("  [2] Agregar ítem a un pedido existente");
            System.out.println("  [3] Cambiar estado de un pedido (Pendiente -> En cocina -> Servido)");
            System.out.println("  [0] Regresar al menú principal");
            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1: {
                    System.out.println("\n--- CREAR NUEVO PEDIDO ---");

                    // CAMBIO: se valida antes de pedir datos, para no crear pedidos vacíos
                    if (listaMenu.isEmpty()) {
                        error("No hay productos en el menú. Registre algunos primero.");
                        break;
                    }
                    if (listaMesas.isEmpty()) {
                        error("No hay mesas registradas. Registre una primero.");
                        break;
                    }

                    System.out.println("--- Datos del Cliente ---");
                    String cedula = leerTexto(scanner, "Cédula: ");
                    String nombre = leerTexto(scanner, "Nombre: ");
                    String telefono = leerTexto(scanner, "Teléfono: ");
                    Cliente clienteActual = new Cliente(cedula, nombre, false, telefono);

                    String idMesa = leerTexto(scanner, "Número de Mesa que desea ocupar: ");
                    Mesa mesaEncontrada = buscarMesa(listaMesas, idMesa);

                    if (mesaEncontrada == null) {
                        error("Mesa no encontrada.");
                        break;
                    }
                    if (mesaEncontrada.isOcupada()) {
                        error("La mesa ya está ocupada.");
                        break;
                    }

                    // CAMBIO: ID único (el mayor existente + 1) en lugar de size() + 1
                    Pedido nuevoPedido = new Pedido(siguienteIdPedido(listaPedidos), mesaEncontrada, clienteActual);

                    int itemsAgregados = 0;
                    boolean pidiendo = true;
                    while (pidiendo) {
                        mostrarMenu(listaMenu);
                        System.out.println("  [0] Terminar de pedir");
                        int opcProducto = leerEntero(scanner, "Seleccione el número del producto: ");

                        if (opcProducto == 0) {
                            pidiendo = false;
                        } else if (opcProducto > 0 && opcProducto <= listaMenu.size()) {
                            Menu productoElegido = listaMenu.get(opcProducto - 1);
                            int cantidad = leerEntero(scanner, "Cantidad: ");

                            if (cantidad <= 0) {
                                error("La cantidad debe ser mayor que 0.");
                            } else {
                                nuevoPedido.agregarItem(new Detalle_Pedido(productoElegido, cantidad));
                                itemsAgregados++;
                                ok("Producto agregado al pedido.");
                            }
                        } else {
                            error("Producto inválido. Elija un número de la lista.");
                        }
                    }

                    
                    if (itemsAgregados > 0) {
                        listaPedidos.add(nuevoPedido);
                        mesaEncontrada.setOcupado(true);
                        ok("Pedido " + nuevoPedido.getIdPedido() + " creado para la mesa " + mesaEncontrada.getId() + ".");
                    } else {
                        aviso("El pedido no tiene productos, no se creó.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("\n--- AGREGAR ÍTEM A UN PEDIDO EXISTENTE ---");
                    Pedido pedidoBuscado = buscarPedidoActivo(scanner, listaPedidos);
                    if (pedidoBuscado == null) break;

                    if (pedidoBuscado.getEstadoPedido().equals(PAGADO)) {
                        error("Ese pedido ya fue pagado.");
                        break;
                    }
                    if (listaMenu.isEmpty()) {
                        error("No hay menú disponible.");
                        break;
                    }

                    mostrarMenu(listaMenu);
                    int opcProducto = leerEntero(scanner, "Seleccione el número del producto a agregar: ");

                    if (opcProducto > 0 && opcProducto <= listaMenu.size()) {
                        Menu productoElegido = listaMenu.get(opcProducto - 1);
                        int cantidad = leerEntero(scanner, "Cantidad: ");

                        if (cantidad <= 0) {
                            error("La cantidad debe ser mayor que 0.");
                        } else {
                            pedidoBuscado.agregarItem(new Detalle_Pedido(productoElegido, cantidad));
                            ok("Ítem agregado al pedido exitosamente.");
                        }
                    } else {
                        error("Producto no válido.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("\n--- CAMBIAR ESTADO DEL PEDIDO ---");
                    Pedido pedidoEstado = buscarPedidoActivo(scanner, listaPedidos);
                    if (pedidoEstado == null) break;

                    if (pedidoEstado.getEstadoPedido().equals(PAGADO)) {
                        error("Ese pedido ya fue pagado.");
                        break;
                    }

                    System.out.println("\nSeleccione el nuevo estado:");
                    System.out.println("  [1] " + PENDIENTE);
                    System.out.println("  [2] " + EN_COCINA);
                    System.out.println("  [3] " + SERVIDO);
                    int opEstado = leerEntero(scanner, "Opción: ");

                    switch (opEstado) {
                        case 1:
                            pedidoEstado.setEstadoPedido(PENDIENTE);
                            ok("Estado actualizado a: " + PENDIENTE);
                            break;
                        case 2:
                            pedidoEstado.setEstadoPedido(EN_COCINA);
                            ok("Estado actualizado a: " + EN_COCINA);
                            break;
                        case 3:
                            pedidoEstado.setEstadoPedido(SERVIDO);
                            ok("Estado actualizado a: " + SERVIDO);
                            break;
                        default:
                            error("Opción de estado inválida.");
                            break;
                    }
                    break;
                }
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    error("Opción inválida.");
            }
        } while (opcion != 0);
    }


    
    public static void menuFacturacion(Scanner scanner, List<Pedido> listaPedidos, List<Mesa> listaMesas) {
        int opcion;
        do {
            titulo("FACTURACIÓN Y CUENTAS");
            System.out.println("  [1] Generar pre-cuenta de un pedido (Subtotal e impuestos)");
            System.out.println("  [2] Aplicar descuento a la cuenta");
            System.out.println("  [3] Procesar pago y finalizar pedido (Servido -> Pagado)");
            System.out.println("  [0] Regresar al menú principal");
            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1: {
                    System.out.println("\n--- GENERAR PRE-CUENTA ---");
                    Pedido pedidoPre = buscarPedidoActivo(scanner, listaPedidos);
                    if (pedidoPre != null) {
                        mostrarPreCuenta(pedidoPre);
                    }
                    break;
                }
                case 2: {
                    System.out.println("\n--- APLICAR DESCUENTO ---");
                    Pedido pedidoDesc = buscarPedidoActivo(scanner, listaPedidos);
                    if (pedidoDesc == null) break;

                    if (pedidoDesc.getEstadoPedido().equals(PAGADO)) {
                        error("Ese pedido ya fue pagado.");
                        break;
                    }

                    double subtotal = pedidoDesc.calcularSubtotal();
                    double porcentaje = leerDecimal(scanner, "Porcentaje de descuento (ej. 10 para 10%): ");

                    
                    if (porcentaje < 0 || porcentaje > 100) {
                        error("El descuento debe estar entre 0 y 100.");
                        break;
                    }

                    pedidoDesc.setPorcentajeDescuento(porcentaje);

                    double descuento = subtotal * (porcentaje / 100.0);
                    double subtotalConDesc = subtotal - descuento;
                    double impuesto = subtotalConDesc * 0.15;
                    double totalFinal = subtotalConDesc + impuesto;

                    System.out.println();
                    System.out.printf("%-28s $%9.2f%n", "Subtotal original:", subtotal);
                    System.out.printf("%-28s -$%8.2f%n", "Descuento aplicado:", descuento);
                    System.out.printf("%-28s $%9.2f%n", "Nuevo Total con Impuesto (15%):", totalFinal);
                    ok("Descuento guardado y aplicado al pedido.");
                    break;
                }
                case 3: {
                    System.out.println("\n--- PROCESAR PAGO ---");
                    Pedido pedidoPago = buscarPedidoActivo(scanner, listaPedidos);
                    if (pedidoPago == null) break;

                    if (pedidoPago.getEstadoPedido().equals(PAGADO)) {
                        error("Ese pedido ya fue pagado.");
                        break;
                    }

                    if (!pedidoPago.getEstadoPedido().equals(SERVIDO)) {
                        aviso("El pedido no está servido.");
                        if (!confirmar(scanner, "¿Desea continuar de todos modos? (s/n): ")) break;
                    }

                    System.out.printf("%nTotal a cobrar: $%.2f%n", pedidoPago.calcularTotal());
                    System.out.println("  [1] Efectivo");
                    System.out.println("  [2] Tarjeta");
                    int metodo = leerEntero(scanner, "Seleccione método de pago: ");

                   
                    Pago pago = null;
                    if (metodo == 1) {
                        pago = new PagoEfectivo();
                    } else if (metodo == 2) {
                        pago = new PagoTarjeta();
                    } else {
                        error("Método inválido.");
                    }

                    if (pago != null) {
                        if (pago.procesarPago(pedidoPago)) {
                            pedidoPago.setEstadoPedido(PAGADO);
                            pedidoPago.getMesa().setOcupado(false);
                            ok("Pago procesado con " + pago.getTipoPago() + ". Pedido finalizado y mesa liberada.");
                        } else {
                            error("El pago no se pudo completar. El pedido sigue activo.");
                        }
                    }
                    break;
                }
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    error("Opción inválida.");
            }
        } while (opcion != 0);
    }


    
    public static void menuConsultasReportes(Scanner scanner, List<Menu> listaMenu, List<Pedido> listaPedidos) {
        int opcion;
        do {
            titulo("CONSULTAS Y REPORTES BÁSICOS");
            System.out.println("  [1] Ver listado general del menú");
            System.out.println("  [2] Total dinero recaudado (Pedidos Pagados)");
            System.out.println("  [0] Regresar al menú principal");
            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    mostrarMenu(listaMenu);
                    break;
                case 2: {
                    System.out.println("\n--- TOTAL DINERO RECAUDADO ---");
                    double totalRecaudado = 0;
                    int pagados = 0;
                    for (Pedido p : listaPedidos) {
                        if (p.getEstadoPedido().equals(PAGADO)) {
                            totalRecaudado += p.calcularTotal();
                            pagados++;
                        }
                    }
                    System.out.printf("Pedidos pagados: %d%n", pagados);
                    System.out.printf("Total ingresado: $%.2f%n", totalRecaudado);
                    break;
                }
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    error("Opción inválida.");
            }
        } while (opcion != 0);
    }


    
    public static void mostrarMenu(List<Menu> listaMenu) {
        System.out.println("\n--- MENÚ DEL RESTAURANTE ---");
        if (listaMenu.isEmpty()) {
            System.out.println("El menú está vacío.");
            return;
        }
        for (int i = 0; i < listaMenu.size(); i++) {
            System.out.printf("  [%d] ", i + 1);
            listaMenu.get(i).mostrarInformacion();
        }
    }

    
    public static void mostrarPreCuenta(Pedido pedido) {
        double subtotal = pedido.calcularSubtotal();
        double total = pedido.calcularTotal();
        double impuesto = total - subtotal;

        System.out.println("\n" + LINEA);
        System.out.println("                 PRE-CUENTA");
        System.out.println(LINEA);
        System.out.println("Pedido ID : " + pedido.getIdPedido());
        System.out.println("Cliente   : " + pedido.getCliente().getNombre());
        System.out.println("Mesa      : " + pedido.getMesa().getId());
        System.out.println("Estado    : " + pedido.getEstadoPedido());
        System.out.println(SEPARADOR);
        System.out.printf("%-24s %5s %12s%n", "PRODUCTO", "CANT", "SUBTOTAL");
        System.out.println(SEPARADOR);

        for (Detalle_Pedido d : pedido.getDetalles()) {
            System.out.printf("%-24s %5d $%10.2f%n",
                    d.getProducto().getNombre(),
                    d.getCantidad(),
                    d.calcularSubtotalPorProducto());
        }

        System.out.println(SEPARADOR);
        System.out.printf("%-30s $%10.2f%n", "Subtotal:", subtotal);
        System.out.printf("%-30s $%10.2f%n", "Impuesto (15%):", impuesto);
        System.out.printf("%-30s $%10.2f%n", "TOTAL A PAGAR:", total);
        System.out.println(LINEA);
    }

    public static Mesa buscarMesa(List<Mesa> listaMesas, String id) {
        for (Mesa m : listaMesas) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }

    public static int siguienteIdPedido(List<Pedido> listaPedidos) {
        int mayor = 0;
        for (Pedido p : listaPedidos) {
            if (p.getIdPedido() > mayor) {
                mayor = p.getIdPedido();
            }
        }
        return mayor + 1;
    }

    public static Pedido buscarPedidoActivo(Scanner scanner, List<Pedido> listaPedidos) {
        if (listaPedidos.isEmpty()) {
            aviso("No hay pedidos registrados en el sistema.");
            return null;
        }

        System.out.println("\n--- Listado de Pedidos ---");
        System.out.printf("%-6s %-8s %-15s%n", "ID", "MESA", "ESTADO");
        System.out.println(SEPARADOR);
        for (Pedido p : listaPedidos) {
            System.out.printf("%-6d %-8s %-15s%n", p.getIdPedido(), p.getMesa().getId(), p.getEstadoPedido());
        }

        int id = leerEntero(scanner, "\nIngrese el ID del Pedido: ");

        for (Pedido p : listaPedidos) {
            if (p.getIdPedido() == id) {
                return p;
            }
        }
        error("Pedido no encontrado.");
        return null;
    }

 
    
    
    
    
    
    
    public static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                error("Ingrese un número entero válido.");
            }
        }
    }

    public static double leerDecimal(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                error("Ingrese un número válido.");
            }
        }
    }

    public static double leerPrecio(Scanner scanner, String mensaje) {
        double precio;
        do {
            precio = leerDecimal(scanner, mensaje);
            if (precio <= 0) {
                error("El precio debe ser mayor que 0.");
            }
        } while (precio <= 0);
        return precio;
    }

    public static String leerTexto(Scanner scanner, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                error("Este campo no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    public static boolean confirmar(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String resp = scanner.nextLine().trim();
            if (resp.equalsIgnoreCase("s")) {
                return true;
            }
            if (resp.equalsIgnoreCase("n")) {
                return false;
            }
            error("Responda con 's' o 'n'.");
        }
    }

    

    public static void titulo(String texto) {
        System.out.println("\n" + LINEA);
        System.out.println("  " + texto);
        System.out.println(LINEA);
    }

    public static void ok(String mensaje) {
        System.out.println("[OK] " + mensaje);
    }

    public static void error(String mensaje) {
        System.out.println("[ERROR] " + mensaje);
    }

    public static void aviso(String mensaje) {
        System.out.println("[AVISO] " + mensaje);
    }
}