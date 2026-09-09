import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registro {
    private String visitante;
    private String tipo;
    private String movimiento;
    private LocalDateTime fechaHora;

    public Registro(String visitante, String tipo, String movimiento) {
        this.visitante = visitante;
        this.tipo = tipo;
        this.movimiento = movimiento;
        this.fechaHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return fechaHora.format(formato) + " | " + movimiento + " | " + visitante + " | " + tipo;
    }
}
