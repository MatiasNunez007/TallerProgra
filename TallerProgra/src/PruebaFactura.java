import javax.swing.JOptionPane;

public class PruebaFactura {

    public static void main(String[] args) {
        String numeroPieza = leerTexto("Ingrese el número de pieza:");
        if (numeroPieza == null) {
            return;
        }
        String descripcion = leerTexto("Ingrese la descripción de la pieza:");
        if (descripcion == null) {
            return;
        }
        Integer cantidad = leerEntero("Ingrese la cantidad de artículos:");
        if (cantidad == null) {
            return;
        }
        Double precio = leerDecimal("Ingrese el precio por artículo:");
        if (precio == null) {
            return;
        }

        Factura factura = new Factura(numeroPieza, descripcion, cantidad, precio);
        mostrarFactura("FACTURA INGRESADA", factura);

        Integer nuevaCantidad = leerEntero("Ingrese una nueva cantidad (puede ser negativa para probar la validación):");
        if (nuevaCantidad == null) {
            return;
        }
        Double nuevoPrecio = leerDecimal("Ingrese un nuevo precio (puede ser negativo para probar la validación):");
        if (nuevoPrecio == null) {
            return;
        }

        factura.setCantidad(nuevaCantidad);
        factura.setPrecio(nuevoPrecio);
        mostrarFactura("FACTURA ACTUALIZADA", factura);
    }

    private static void mostrarFactura(String titulo, Factura factura) {
        String mensaje = "Número de pieza: " + factura.getNumeroPieza()
                + "\nDescripción: " + factura.getDescripcion()
                + "\nCantidad: " + factura.getCantidad()
                + "\nPrecio por artículo: $" + String.format("%.2f", factura.getPrecio())
                + "\nMonto de la factura: $" + String.format("%.2f", factura.obtenerMontoFactura());
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private static String leerTexto(String mensaje) {
        while (true) {
            String texto = JOptionPane.showInputDialog(null, mensaje, "Factura", JOptionPane.QUESTION_MESSAGE);
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
            String texto = JOptionPane.showInputDialog(null, mensaje, "Factura", JOptionPane.QUESTION_MESSAGE);
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

    private static Double leerDecimal(String mensaje) {
        while (true) {
            String texto = JOptionPane.showInputDialog(null, mensaje, "Factura", JOptionPane.QUESTION_MESSAGE);
            if (texto == null) {
                return null;
            }
            try {
                return Double.parseDouble(texto.trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
