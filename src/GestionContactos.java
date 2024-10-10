public interface GestionContactos {
    boolean añadirContacto(Contacto contacto);
    boolean eliminarContacto(String nombre, String apellido);
    boolean modificarTelefono(String nombre, String apellido, String nuevoTelefono);
    void listarContactos();
    Contacto buscarContacto(String nombre, String apellido);
    boolean agendaLlena();
    int espaciosLibres();
}