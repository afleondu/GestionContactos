import java.util.Objects;

public abstract class Contacto {
    protected String nombre;
    protected String apellido;
    protected String telefono;

    public Contacto(String nombre, String apellido, String telefono) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        if (apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }

        this.nombre = formatearNombre(nombre);
        this.apellido = formatearApellido(apellido);
        this.telefono = telefono;
    }

    private String formatearNombre(String nombre) {
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
    }

    private String formatearApellido(String apellido) {
        return Contacto.this.apellido.substring(0, 1).toUpperCase() + Contacto.this.apellido.substring(1).toLowerCase();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto contacto = (Contacto) obj;
        return nombre.equals(contacto.nombre) && apellido.equals(contacto.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}