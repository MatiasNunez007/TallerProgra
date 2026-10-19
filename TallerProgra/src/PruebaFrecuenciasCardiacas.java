import java.util.Scanner;

public class PruebaFrecuenciasCardiacas {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el primer nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido = entrada.nextLine();

        int mes;
        int dia;
        int anio;
        while (true) {
            mes = leerEntero(entrada, "Ingrese el mes de nacimiento (1-12): ");
            dia = leerEntero(entrada, "Ingrese el día de nacimiento (1-31): ");
            anio = leerEntero(entrada, "Ingrese el año de nacimiento (ej. 2004): ");
            if (FrecuenciasCardiacas.esFechaValida(mes, dia, anio)) {
                break;
            }
            System.out.println("Error: la fecha no existe o es posterior a hoy. Intente de nuevo.\n");
        }

        FrecuenciasCardiacas persona = new FrecuenciasCardiacas(nombre, apellido, mes, dia, anio);

        System.out.println("\n========================================");
        System.out.println("   INFORMACIÓN DE LA PERSONA Y SU SALUD");
        System.out.println("========================================");
        System.out.println("Primer nombre: " + persona.getNombre());
        System.out.println("Apellido: " + persona.getApellido());
        System.out.println("Fecha de nacimiento (mes/día/año): " + persona.getMesNacimiento() + "/"
                + persona.getDiaNacimiento() + "/" + persona.getAnioNacimiento());
        System.out.println("Edad: " + persona.obtenerEdad() + " años");
        System.out.println("Frecuencia cardíaca máxima: " + persona.obtenerFrecuenciaMaxima() + " bpm");
        System.out.println("Rango de frecuencia cardíaca esperada: " + persona.obtenerFrecuenciaEsperada());
        System.out.println("========================================");
        System.out.println("Consulte a un médico antes de iniciar o modificar un programa de ejercicios.");

        entrada.close();
    }

    private static int leerEntero(Scanner entrada, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = entrada.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número entero válido.");
            }
        }
    }
}
