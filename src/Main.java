import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Residente> residentes = new ArrayList<>();
    static ArrayList<Visitante> visitantes = new ArrayList<>();
    static ArrayList<Registro> bitacora = new ArrayList<>();
    static int siguienteResidente = 1;
    static int siguienteVisitante = 1;

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1 -> registrarResidente();
                case 2 -> modificarResidente();
                case 3 -> eliminarResidente();
                case 4 -> mostrarResidentes();
                case 5 -> registrarVisitante();
                case 6 -> mostrarVisitantes();
                case 7 -> registrarMovimiento("ENTRADA");
                case 8 -> registrarMovimiento("SALIDA");
                case 9 -> mostrarBitacora();
                case 0 -> System.out.println("Sistema finalizado.");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    static void mostrarMenu() {
        System.out.println("\n=== CONTROL DE ACCESO - COLONIA PRIVADA ===");
        System.out.println("1. Alta de residente");
        System.out.println("2. Modificar residente");
        System.out.println("3. Baja de residente");
        System.out.println("4. Mostrar residentes");
        System.out.println("5. Registrar visitante");
        System.out.println("6. Mostrar visitantes");
        System.out.println("7. Registrar entrada");
        System.out.println("8. Registrar salida");
        System.out.println("9. Ver bitacora");
        System.out.println("0. Salir");
    }

    static void registrarResidente() {
        System.out.print("Nombre del residente: ");
        String nombre = sc.nextLine();
        System.out.print("Casa o departamento: ");
        String vivienda = sc.nextLine();
        residentes.add(new Residente(siguienteResidente++, nombre, vivienda));
        System.out.println("Residente registrado correctamente.");
    }

    static void modificarResidente() {
        mostrarResidentes();
        int id = leerEntero("ID del residente a modificar: ");
        Residente r = buscarResidente(id);
        if (r == null) {
            System.out.println("Residente no encontrado.");
            return;
        }
        System.out.print("Nuevo nombre: ");
        r.setNombre(sc.nextLine());
        System.out.print("Nueva casa/departamento: ");
        r.setVivienda(sc.nextLine());
        System.out.println("Residente modificado.");
    }

    static void eliminarResidente() {
        mostrarResidentes();
        int id = leerEntero("ID del residente a eliminar: ");
        Residente r = buscarResidente(id);
        if (r != null) {
            residentes.remove(r);
            System.out.println("Residente eliminado.");
        } else {
            System.out.println("Residente no encontrado.");
        }
    }

    static void mostrarResidentes() {
        System.out.println("\n--- RESIDENTES ---");
        if (residentes.isEmpty()) System.out.println("No hay residentes registrados.");
        else residentes.forEach(System.out::println);
    }

    static Residente buscarResidente(int id) {
        for (Residente r : residentes) if (r.getId() == id) return r;
        return null;
    }

    static void registrarVisitante() {
        System.out.print("Nombre del visitante: ");
        String nombre = sc.nextLine();
        System.out.println("Tipo: 1) Familia  2) Proveedor  3) Taxi  4) Otro");
        int tipoNum = leerEntero("Selecciona: ");
        String tipo = switch (tipoNum) {
            case 1 -> "Familia";
            case 2 -> "Proveedor";
            case 3 -> "Taxi";
            default -> "Otro";
        };
        System.out.print("Nombre del residente/casa que visita: ");
        String visitaA = sc.nextLine();
        visitantes.add(new Visitante(siguienteVisitante++, nombre, tipo, visitaA));
        System.out.println("Visitante registrado correctamente.");
    }

    static void mostrarVisitantes() {
        System.out.println("\n--- VISITANTES ---");
        if (visitantes.isEmpty()) System.out.println("No hay visitantes registrados.");
        else visitantes.forEach(System.out::println);
    }

    static Visitante buscarVisitante(int id) {
        for (Visitante v : visitantes) if (v.getId() == id) return v;
        return null;
    }

    static void registrarMovimiento(String movimiento) {
        mostrarVisitantes();
        int id = leerEntero("ID del visitante: ");
        Visitante v = buscarVisitante(id);
        if (v == null) {
            System.out.println("Visitante no encontrado.");
            return;
        }
        bitacora.add(new Registro(v.getNombre(), v.getTipo(), movimiento));
        System.out.println(movimiento + " registrada correctamente.");
    }

    static void mostrarBitacora() {
        System.out.println("\n--- BITACORA DE ACCESOS ---");
        if (bitacora.isEmpty()) System.out.println("No hay movimientos registrados.");
        else bitacora.forEach(System.out::println);
    }

    static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero valido.");
            }
        }
    }
}
