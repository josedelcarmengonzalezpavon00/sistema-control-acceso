public class Residente {
    private int id;
    private String nombre;
    private String vivienda;

    public Residente(int id, String nombre, String vivienda) {
        this.id = id;
        this.nombre = nombre;
        this.vivienda = vivienda;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getVivienda() { return vivienda; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setVivienda(String vivienda) { this.vivienda = vivienda; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Casa/Depto: " + vivienda;
    }
}
