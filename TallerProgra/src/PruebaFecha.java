import javax.swing.JOptionPane;

public class PruebaFecha {

    public static void main(String[] args) {
        Integer mes = leerEntero("Ingrese el mes:");
        if (mes == null) {
            return;
        }
        Integer dia = leerEntero("Ingrese el día:");
        if (dia == null) {
            return;
        }
        Integer anio = leerEntero("Ingrese el año:");
        if (anio == null) {
            return;
        }

        Fecha fecha = new Fecha(mes, dia, anio);
        System.out.print("La fecha ingresada es: ");
        fecha.mostrarFecha();
        JOptionPane.showMessageDialog(null, "La fecha ingresada es: " + fecha.obtenerFechaTexto(),
                "Fecha", JOptionPane.INFORMATION_MESSAGE);

        Integer nuevoMes = leerEntero("Ingrese el nuevo mes:");
        if (nuevoMes == null) {
            return;
        }
        Integer nuevoDia = leerEntero("Ingrese el nuevo día:");
        if (nuevoDia == null) {
            return;
        }
        Integer nuevoAnio = leerEntero("Ingrese el nuevo año:");
        if (nuevoAnio == null) {
            return;
        }

        fecha.setMes(nuevoMes);
        fecha.setDia(nuevoDia);
        fecha.setAnio(nuevoAnio);

        System.out.print("La fecha actualizada es: ");
        fecha.mostrarFecha();
        JOptionPane.showMessageDialog(null,
                "Mes: " + fecha.getMes() + "\nDía: " + fecha.getDia() + "\nAño: " + fecha.getAnio()
                        + "\n\nLa fecha actualizada es: " + fecha.obtenerFechaTexto(),
                "Fecha actualizada", JOptionPane.INFORMATION_MESSAGE);
    }

    private static Integer leerEntero(String mensaje) {
        while (true) {
            String texto = JOptionPane.showInputDialog(null, mensaje, "Fecha", JOptionPane.QUESTION_MESSAGE);
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
}
