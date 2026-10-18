public static void main(String[] args) {
    Fecha fecha1 = new Fecha(10, 17, 2026);

    // Mostrar la fecha inicial
    System.out.print("La fecha inicial es: ");
    fecha1.mostrarFecha();

    // Modificar los valores usando los métodos set
    fecha1.setMes(12);
    fecha1.setDia(25);
    fecha1.setAnio(2026);

    // Mostrar la fecha modificada
    System.out.print("La fecha actualizada es: ");
    fecha1.mostrarFecha();
}