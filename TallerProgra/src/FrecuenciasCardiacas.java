import java.time.LocalDate;
import java.time.Period;

public class FrecuenciasCardiacas {
    private String nombre;
    private String apellido;
    private int mesNacimiento;
    private int diaNacimiento;
    private int anioNacimiento;

    public FrecuenciasCardiacas(String nombre, String apellido, int mesNacimiento, int diaNacimiento, int anioNacimiento) {
        setNombre(nombre);
        setApellido(apellido);
        if (esFechaValida(mesNacimiento, diaNacimiento, anioNacimiento)) {
            this.mesNacimiento = mesNacimiento;
            this.diaNacimiento = diaNacimiento;
            this.anioNacimiento = anioNacimiento;
        } else {
            this.mesNacimiento = 1;
            this.diaNacimiento = 1;
            this.anioNacimiento = 2000;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            this.nombre = "SIN NOMBRE";
        } else {
            this.nombre = nombre.trim();
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.isBlank()) {
            this.apellido = "SIN APELLIDO";
        } else {
            this.apellido = apellido.trim();
        }
    }

    public int getMesNacimiento() {
        return mesNacimiento;
    }

    public void setMesNacimiento(int mesNacimiento) {
        if (esFechaValida(mesNacimiento, this.diaNacimiento, this.anioNacimiento)) {
            this.mesNacimiento = mesNacimiento;
        }
    }

    public int getDiaNacimiento() {
        return diaNacimiento;
    }

    public void setDiaNacimiento(int diaNacimiento) {
        if (esFechaValida(this.mesNacimiento, diaNacimiento, this.anioNacimiento)) {
            this.diaNacimiento = diaNacimiento;
        }
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        if (esFechaValida(this.mesNacimiento, this.diaNacimiento, anioNacimiento)) {
            this.anioNacimiento = anioNacimiento;
        }
    }

    public static boolean esFechaValida(int mes, int dia, int anio) {
        try {
            LocalDate fecha = LocalDate.of(anio, mes, dia);
            return !fecha.isAfter(LocalDate.now());
        } catch (Exception e) {
            return false;
        }
    }

    public int obtenerEdad() {
        LocalDate fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public int obtenerFrecuenciaMaxima() {
        return 220 - obtenerEdad();
    }

    public double obtenerFrecuenciaEsperadaMinima() {
        return obtenerFrecuenciaMaxima() * 0.50;
    }

    public double obtenerFrecuenciaEsperadaMaxima() {
        return obtenerFrecuenciaMaxima() * 0.85;
    }

    public String obtenerFrecuenciaEsperada() {
        return String.format("%.0f - %.0f bpm", obtenerFrecuenciaEsperadaMinima(), obtenerFrecuenciaEsperadaMaxima());
    }
}
