import java.util.Scanner;

public class PruebaEmpleado {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("--- DATOS DEL EMPLEADO 1 ---");
        Empleado empleado1 = leerEmpleado(entrada);
        System.out.println("\n--- DATOS DEL EMPLEADO 2 ---");
        Empleado empleado2 = leerEmpleado(entrada);

        System.out.println("\n--- SALARIOS ANUALES INICIALES ---");
        mostrarSalarioAnual(empleado1);
        mostrarSalarioAnual(empleado2);

        empleado1.setSalario(empleado1.getSalario() * 1.10);
        empleado2.setSalario(empleado2.getSalario() * 1.10);

        System.out.println("\n--- SALARIOS ANUALES CON AUMENTO DEL 10% ---");
        mostrarSalarioAnual(empleado1);
        mostrarSalarioAnual(empleado2);

        entrada.close();
    }

    private static Empleado leerEmpleado(Scanner entrada) {
        System.out.print("Primer nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Apellido paterno: ");
        String apellido = entrada.nextLine();
        double salario = leerDecimal(entrada, "Salario mensual: ");
        if (salario <= 0) {
            System.out.println("Aviso: el salario no es positivo, no se estableció (queda en 0.00).");
        }
        return new Empleado(nombre, apellido, salario);
    }

    private static void mostrarSalarioAnual(Empleado empleado) {
        System.out.printf("%s %s: salario mensual $%.2f, salario anual $%.2f%n",
                empleado.getNombre(), empleado.getApellido(),
                empleado.getSalario(), empleado.obtenerSalarioAnual());
    }

    private static double leerDecimal(Scanner entrada, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = entrada.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número válido.");
            }
        }
    }
}
