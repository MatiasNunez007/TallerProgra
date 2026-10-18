import java.util.Scanner;


public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

    System.out.print("Ingrese el primer nombre: ");
    String nombre = entrada.nextLine();

    System.out.print("Ingrese el apellido: ");
    String apellido = entrada.nextLine();

    // Validar que los números ingresados por consola sean enteros válidos
    int mes = solicitarEntero(entrada, "Ingrese el mes de nacimiento (1-12): ");
    int dia = solicitarEntero(entrada, "Ingrese el día de nacimiento (1-31): ");
    int anio = solicitarEntero(entrada, "Ingrese el año de nacimiento (ej. 2004): ");

    // Crear la instancia (se aplicarán las validaciones internas)
    FrecuenciasCardiacas persona = new FrecuenciasCardiacas(nombre, apellido, mes, dia, anio);

    // Imprimir resultados
    System.out.println("\n========================================");
    System.out.println("   INFORMACIÓN DEL PACIENTE Y SALUD");
    System.out.println("========================================");
    System.out.println("Nombre completo: " + persona.getNombre() + " " + persona.getApellido());
    System.out.println("Fecha de nacimiento: " + persona.getMesNacimiento() + "/" + persona.getDiaNacimiento() + "/" + persona.getAnioNacimiento());
    System.out.println("Edad: " + persona.obtenerEdad() + " años");
    System.out.println("Frecuencia cardíaca máxima: " + persona.obtenerFrecuenciaMaxima() + " bpm");
    System.out.println("Rango de frecuencia cardíaca esperada: " + persona.obtenerFrecuenciaEsperada());
    System.out.println("========================================");

    entrada.close();
}

private static int solicitarEntero(Scanner entrada, String mensaje) {
    int numero;
    while (true) {
        System.out.print(mensaje);
        if (entrada.hasNextInt()) {
            numero = entrada.nextInt();
            break;
        } else {
            System.out.println("Error: Por favor, ingrese un número entero válido.");
            entrada.next(); // Limpiar la entrada incorrecta
        }
    }
    return numero;
}