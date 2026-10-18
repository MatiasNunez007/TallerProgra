public static void main(String[] args) {
        // Crear una factura con datos válidos
        Factura factura1 = new Factura("A-101", "Martillo de acero", 5, 12.50);

        System.out.println("--- FACTURA 1 ---");
        System.out.println("Número de pieza: " + factura1.getNumeroPieza());
        System.out.println("Descripción: " + factura1.getDescripcion());
        System.out.println("Cantidad: " + factura1.getCantidad());
        System.out.println("Precio unitario: $" + factura1.getPrecio());
        System.out.println("Monto total: $" + factura1.obtenerMontoFactura());

        // Probar validación con valores negativos
        Factura factura2 = new Factura("B-202", "Destornillador", -3, -5.00);

        System.out.println("\n--- FACTURA 2 (Con valores negativos) ---");
        System.out.println("Número de pieza: " + factura2.getNumeroPieza());
        System.out.println("Descripción: " + factura2.getDescripcion());
        System.out.println("Cantidad ajustada: " + factura2.getCantidad());
        System.out.println("Precio ajustado: $" + factura2.getPrecio());
        System.out.println("Monto total: $" + factura2.obtenerMontoFactura());
}

