import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Agenda implements GestionContactos {
    private List<Contacto> contactos;
    private int capacidadMaxima;

    public Agenda(int capacidadMaxima) {
        this.contactos = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    @Override
    public boolean añadirContacto(Contacto contacto) {
        if (agendaLlena()) {
            System.out.println("La agenda está llena. ¿Desea ampliar la capacidad? (Sí/No)");
            Scanner scanner = new Scanner(System.in);
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("Sí")) {
                System.out.print("Ingrese la nueva capacidad máxima: ");
                int nuevaCapacidad = scanner.nextInt();
                this.capacidadMaxima = nuevaCapacidad;
                scanner.nextLine();  // Consumir nueva línea
            } else {
                listarContactos();
                return false;
            }
        }

        // Comprobar si el contacto ya existe
        if (existeContacto(contacto.getNombre(), contacto.getApellido())) {
            System.out.println("El contacto ya existe.");
            return false;
        }

        contactos.add(contacto);
        System.out.println("Contacto añadido exitosamente.");
        return true;
    }

    @Override
    public boolean eliminarContacto(String nombre, String apellido) {
        Contacto contacto = buscarContacto(nombre, apellido);
        if (contacto != null) {
            contactos.remove(contacto);
            System.out.println("Contacto eliminado exitosamente.");
            return true;
        } else {
            System.out.println("El contacto no existe.");
            return false;
        }
    }

    @Override
    public boolean modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        Contacto contacto = buscarContacto(nombre, apellido);
        if (contacto != null) {
            contacto.setTelefono(nuevoTelefono);
            System.out.println("Teléfono modificado exitosamente.");
            return true;
        } else {
            System.out.println("El contacto no existe.");
            return false;
        }
    }

    @Override
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos en la agenda.");
            return;
        }

        // Ordenar contactos alfabéticamente
        Collections.sort(contactos, Comparator.comparing(Contacto::getNombre)
                .thenComparing(Contacto::getApellido));

        System.out.println("Lista de contactos:");
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    @Override
    public Contacto buscarContacto(String nombre, String apellido) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre) &&
                    contacto.getApellido().equalsIgnoreCase(apellido)) {
                return contacto;
            }
        }
        return null;
    }

    @Override
    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    @Override
    public int espaciosLibres() {
        return capacidadMaxima - contactos.size();
    }

    public boolean existeContacto(String nombre, String apellido) {
        return buscarContacto(nombre, apellido) != null;
    }
}