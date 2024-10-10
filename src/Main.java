import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Agenda inicial con capacidad máxima de 10 contactos
        Agenda agenda = new Agenda(10);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono de un contacto");
            System.out.println("6. Ver espacio disponible");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    Contacto nuevoContacto = new ContactoPersonal(nombre, apellido, telefono);
                    agenda.añadirContacto(nuevoContacto);
                    break;
                case 2:
                    agenda.listarContactos();
                    break;
                case 3:
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    Contacto contacto = agenda.buscarContacto(nombre, apellido);
                    if (contacto != null) {
                        System.out.println("Teléfono: " + contacto.getTelefono());
                    } else {
                        System.out.println("El contacto no existe.");
                    }
                    break;
                case 4:
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    agenda.eliminarContacto(nombre, apellido);
                    break;
                case 5:
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    System.out.print("Nuevo Teléfono: ");
                    String nuevoTelefono = scanner.nextLine();
                    agenda.modificarTelefono(nombre, apellido, nuevoTelefono);
                    break;
                case 6:
                    System.out.println("Espacios libres: " + agenda.espaciosLibres());
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}