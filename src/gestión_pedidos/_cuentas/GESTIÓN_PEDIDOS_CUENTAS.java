package gestión_pedidos._cuentas;

import java.util.Scanner;

public class GESTIÓN_PEDIDOS_CUENTAS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal = 0;

        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE RESTAURANTE ===");
            System.out.println("1. Gestión del Menú");
            System.out.println("2. Gestión de Mesas");
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
                    menuGestionMenu(scanner);
                    break;
                case 2:
                    menuGestionMesas(scanner);
                    break;
                case 3:
                    menuGestionPedidos(scanner);
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

    
    public static void menuGestionMenu(Scanner scanner) {
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
                    System.out.println("[Lógica] Registrando nuevo plato...");
                    break;
                case 2:
                    System.out.println("[Lógica] Registrando nueva bebida...");
                    break;
                case 3:
                    System.out.println("[Lógica] Registrando nuevo postre...");
                    break;
                case 4:
                    System.out.println("[Lógica] Listando elementos del menú...");
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    
    public static void menuGestionMesas(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Submenú 2: Gestión de Mesas ---");
            System.out.println("1. Registrar nueva mesa (Número y capacidad)");
            System.out.println("2. Asignar mesa a clientes (Disponible -> Ocupada)");
            System.out.println("3. Liberar mesa (Ocupada -> Disponible)");
            System.out.println("4. Ver estado de todas las mesas");
            System.out.println("5. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("[Lógica] Registrando nueva mesa...");
                    break;
                case 2:
                    System.out.println("[Lógica] Asignando mesa a cliente...");
                    break;
                case 3:
                    System.out.println("[Lógica] Liberando mesa...");
                    break;
                case 4:
                    System.out.println("[Lógica] Mostrando estado de las mesas...");
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    
    public static void menuGestionPedidos(Scanner scanner) {
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
                    System.out.println("[Lógica] Creando nuevo pedido...");
                    break;
                case 2:
                    System.out.println("[Lógica] Agregando ítem al pedido...");
                    break;
                case 3:
                    System.out.println("[Lógica] Cambiando estado del pedido...");
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
            System.out.println("2. Ver estado actual de las mesas (Disponibles / Ocupadas)");
            System.out.println("3. Ver listado de pedidos activos por estado");
            System.out.println("4. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("[Lógica] Mostrando listado del menú...");
                    break;
                case 2:
                    System.out.println("[Lógica] Mostrando estado de mesas...");
                    break;
                case 3:
                    System.out.println("[Lógica] Mostrando pedidos activos...");
                    break;
                case 4:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }
}