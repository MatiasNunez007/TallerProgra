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

        // Asignación con validación integrada para la fecha
        if (esFechaValida(mesNacimiento, diaNacimiento, anioNacimiento)) {
            this.mesNacimiento = mesNacimiento;
            this.diaNacimiento = diaNacimiento;
            this.anioNacimiento = anioNacimiento;
        } else {
            // Valores por defecto si la fecha inicial no es válida (ej. 1 de enero de 2000)
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

    private boolean esFechaValida(int mes, int dia, int anio) {
        try {
            LocalDate fecha = LocalDate.of(anio, mes, dia);
            // La fecha de nacimiento no puede ser posterior al día de hoy
            return !fecha.isAfter(LocalDate.now());
        } catch (Exception e) {
            return false; // Si el día/mes/año no existen (ej. 30 de febrero), lanza excepción y retorna false
        }
    }

    // --- CÁLCULOS DE FRECUENCIA ---
    public int obtenerEdad() {
        LocalDate fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }

    public int obtenerFrecuenciaMaxima() {
        return 220 - obtenerEdad();
    }

    public String obtenerFrecuenciaEsperada() {
        int max = obtenerFrecuenciaMaxima();
        double minEsperada = max * 0.50;
        double maxEsperada = max * 0.85;
        return String.format("%.0f - %.0f bpm", minEsperada, maxEsperada);
    }
}