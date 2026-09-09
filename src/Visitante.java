public class Visitante {
    private int id;
    private String nombre;
    private String tipo;
    private String visitaA;

    public Visitante(int id, String nombre, String tipo, String visitaA) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.visitaA = visitaA;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public String getVisitaA() { return visitaA; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Tipo: " + tipo + " | Visita a: " + visitaA;
    }
}
