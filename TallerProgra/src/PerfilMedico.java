import java.time.LocalDate;
import java.time.Period;

public class PerfilMedico {
    private String nombre;
    private String apellido;
    private String sexo;
    private int diaNacimiento;
    private int mesNacimiento;
    private int anioNacimiento;
    private double altura;
    private double peso;

    public PerfilMedico(String nombre, String apellido, String sexo, int diaNacimiento, int mesNacimiento,
                        int anioNacimiento, double altura, double peso) {
        setNombre(nombre);
        setApellido(apellido);
        setSexo(sexo);
        if (esFechaValida(mesNacimiento, diaNacimiento, anioNacimiento)) {
            this.diaNacimiento = diaNacimiento;
            this.mesNacimiento = mesNacimiento;
            this.anioNacimiento = anioNacimiento;
        } else {
            this.diaNacimiento = 1;
            this.mesNacimiento = 1;
            this.anioNacimiento = 2000;
        }
        this.altura = 1.0;
        this.peso = 1.0;
        setAltura(altura);
        setPeso(peso);
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        if (sexo == null || sexo.isBlank()) {
            this.sexo = "NO ESPECIFICADO";
        } else {
            this.sexo = sexo.trim();
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

    public int getMesNacimiento() {
        return mesNacimiento;
    }

    public void setMesNacimiento(int mesNacimiento) {
        if (esFechaValida(mesNacimiento, this.diaNacimiento, this.anioNacimiento)) {
            this.mesNacimiento = mesNacimiento;
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

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso > 0) {
            this.peso = peso;
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

    public String obtenerFrecuenciaEsperada() {
        int max = obtenerFrecuenciaMaxima();
        return String.format("%.0f - %.0f bpm", max * 0.50, max * 0.85);
    }

    public double calcularBMI() {
        double alturaMetros = altura / 100.0;
        return peso / (alturaMetros * alturaMetros);
    }

    public String obtenerCategoriaBMI() {
        double bmi = calcularBMI();
        if (bmi < 18.5) {
            return "Bajo peso";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Sobrepeso";
        } else {
            return "Obeso";
        }
    }
}
