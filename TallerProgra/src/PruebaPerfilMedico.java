import javax.swing.JOptionPane;

public class PruebaPerfilMedico {

    public static void main(String[] args) {
        String nombre = leerTexto("Ingrese el primer nombre:");
        if (nombre == null) {
            return;
        }
        String apellido = leerTexto("Ingrese el apellido:");
        if (apellido == null) {
            return;
        }
        String sexo = leerTexto("Ingrese el sexo (Masculino / Femenino):");
        if (sexo == null) {
            return;
        }

        int dia;
        int mes;
        int anio;
        while (true) {
            Integer d = leerEntero("Ingrese el día de nacimiento (1-31):");
            if (d == null) {
                return;
            }
            Integer m = leerEntero("Ingrese el mes de nacimiento (1-12):");
            if (m == null) {
                return;
            }
            Integer a = leerEntero("Ingrese el año de nacimiento (ej. 2004):");
            if (a == null) {
                return;
            }
            if (PerfilMedico.esFechaValida(m, d, a)) {
                dia = d;
                mes = m;
                anio = a;
                break;
            }
            JOptionPane.showMessageDialog(null, "La fecha no existe o es posterior a hoy. Intente de nuevo.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        Double altura = leerDecimalPositivo("Ingrese la altura en centímetros (ej. 170):");
        if (altura == null) {
            return;
        }
        Double peso = leerDecimalPositivo("Ingrese el peso en kilogramos (ej. 65.5):");
        if (peso == null) {
            return;
        }

        PerfilMedico perfil = new PerfilMedico(nombre, apellido, sexo, dia, mes, anio, altura, peso);

        String datos = "Primer nombre: " + perfil.getNombre()
                + "\nApellido: " + perfil.getApellido()
                + "\nSexo: " + perfil.getSexo()
                + "\nFecha de nacimiento (día/mes/año): " + perfil.getDiaNacimiento() + "/"
                + perfil.getMesNacimiento() + "/" + perfil.getAnioNacimiento()
                + "\nAltura: " + String.format("%.1f", perfil.getAltura()) + " cm"
                + "\nPeso: " + String.format("%.1f", perfil.getPeso()) + " kg";
        JOptionPane.showMessageDialog(null, datos, "Datos del perfil médico", JOptionPane.INFORMATION_MESSAGE);

        String resultados = "Edad: " + perfil.obtenerEdad() + " años"
                + "\nBMI: " + String.format("%.2f", perfil.calcularBMI()) + " (" + perfil.obtenerCategoriaBMI() + ")"
                + "\nFrecuencia cardíaca máxima: " + perfil.obtenerFrecuenciaMaxima() + " bpm"
                + "\nRango de frecuencia cardíaca esperada: " + perfil.obtenerFrecuenciaEsperada()
                + "\n\nVALORES DE BMI"
                + "\nBajo peso: menos de 18.5"
                + "\nNormal: entre 18.5 y 24.9"
                + "\nSobrepeso: entre 25 y 29.9"
                + "\nObeso: 30 o más"
                + "\n\nConsulte a un médico antes de iniciar o modificar un programa de ejercicios.";
        JOptionPane.showMessageDialog(null, resultados, "Resultados de salud", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String leerTexto(String mensaje) {
        while (true) {
            String texto = JOptionPane.showInputDialog(null, mensaje, "Perfil médico", JOptionPane.QUESTION_MESSAGE);
            if (texto == null) {
                return null;
            }
            if (!texto.isBlank()) {
                return texto;
            }
            JOptionPane.showMessageDialog(null, "El campo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static Integer leerEntero(String mensaje) {
        while (true) {
            String texto = JOptionPane.showInputDialog(null, mensaje, "Perfil médico", JOptionPane.QUESTION_MESSAGE);
            if (texto == null) {
                return null;
            }
            try {
                return Integer.parseInt(texto.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static Double leerDecimalPositivo(String mensaje) {
        while (true) {
            String texto = JOptionPane.showInputDialog(null, mensaje, "Perfil médico", JOptionPane.QUESTION_MESSAGE);
            if (texto == null) {
                return null;
            }
            try {
                double valor = Double.parseDouble(texto.trim().replace(',', '.'));
                if (valor > 0) {
                    return valor;
                }
                JOptionPane.showMessageDialog(null, "El valor debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
