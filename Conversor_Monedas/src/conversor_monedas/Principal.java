package conversor_monedas;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numeroDeOpcion = "";

        while (!numeroDeOpcion.equals("9")&&!numeroDeOpcion.equals("no") ) {
            System.out.println("---------------------------------------------");
            System.out.println("¿CUAL VA A SER TU CONVERSION EL DIA DE HOY?");
            System.out.println("---------------------------------------------");
            System.out.print("""
                             Marca 1 para pasar de: Dolares a Pesos Argentinos
                             Marca 2 para pasar de: Pesos Argentinos a Dolares
                             Marca 3 para pasar de: Dolares a Real Brasileño
                             Marca 4 para pasar de: Real Brasileño a Dolares
                             Marca 5 para pasar de: Dolares a Peso Colombiano
                             Marca 6 para pasar de: Peso Colombiano a Dolares
                             Marca 9 para salir
                             """);
            System.out.println("---------------------------------------------");
            System.out.print("MARCA TU OPCION PARA LA CONVERSION: ");
            numeroDeOpcion = scanner.nextLine();

            // Verificar si el usuario eligió salir
            if (numeroDeOpcion.equals("9")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.println("---------------------------------------------");
            System.out.print("SELECCIONA LA CANTIDAD A CONVERTIR: ");
            String laCantidad = scanner.nextLine();
            System.out.println("---------------------------------------------");

            DivisasCalculo conversor = new DivisasCalculo();
            conversor.resultadoConversion(numeroDeOpcion, laCantidad);

            System.out.println("---------------------------------------------");
            System.out.print("¿Deseas continuar? si / no : ");
            numeroDeOpcion = scanner.nextLine();
            if (numeroDeOpcion.equals("no")) {
                System.out.println("Saliendo del programa...");
                break;
            }
        }
    }
}
