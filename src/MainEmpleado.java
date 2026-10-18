public static void main(String[] args) {
            // Crear dos objetos Empleado (uno con salario válido y otro con negativo para probar la validación)
            Empleado emp1 = new Empleado("Pepe", "Tola", 1200.00);
            Empleado emp2 = new Empleado("Carlos", "Perez", -500.00); // Se ajustará a 0.0 por la regla del constructor

            // Asignar un salario válido a emp2 para la prueba
            emp2.setSalario(1500.00);

            // Mostrar el salario anual inicial
            System.out.println("--- SALARIOS ANUALES INICIALES ---");
            System.out.println(emp1.getNombre() + " " + emp1.getApellido() + ": $" + emp1.obtenerSalarioAnual());
            System.out.println(emp2.getNombre() + " " + emp2.getApellido() + ": $" + emp2.obtenerSalarioAnual());

            // Aplicar aumento del 10% a cada empleado
            emp1.setSalario(emp1.getSalario() * 1.10);
            emp2.setSalario(emp2.getSalario() * 1.10);

            // Mostrar el salario anual actualizado
            System.out.println("\n--- SALARIOS ANUALES CON AUMENTO DEL 10% ---");
            System.out.println(emp1.getNombre() + " " + emp1.getApellido() + ": $" + emp1.obtenerSalarioAnual());
            System.out.println(emp2.getNombre() + " " + emp2.getApellido() + ": $" + emp2.obtenerSalarioAnual());
}