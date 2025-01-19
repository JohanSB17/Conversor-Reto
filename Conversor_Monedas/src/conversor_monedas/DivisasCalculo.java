package conversor_monedas;

public class DivisasCalculo {
    
    public void resultadoConversion(String tipoDivisa, String cantidadAConvertir) {
        String deDivisa = "", aDivisa = "";
        switch (tipoDivisa) {
            case "1" -> {
                deDivisa = "USD";
                aDivisa = "ARS";
            }
            case "2" -> {
                deDivisa = "ARS";
                aDivisa = "USD";
            }
            case "3" -> {
                deDivisa = "USD";
                aDivisa = "BRL";
            }
            case "4" -> {
                deDivisa = "BRL";
                aDivisa = "USD";
            }
            case "5" -> {
                deDivisa = "USD";
                aDivisa = "COP";
            }
            case "6" -> {
                deDivisa = "COP";
                aDivisa = "USD";
            }
            default -> {
                System.out.println("Opcion de conversion no valida");
                return;
            }
        }
        try {
            System.out.println("Cantidad a convertir: " + cantidadAConvertir + deDivisa);
            ApiDivisa res = new ApiDivisa();
            double cantidadConvertida = res.get(cantidadAConvertir, deDivisa, aDivisa);
            System.out.print(cantidadAConvertir + " " + deDivisa + " equivale a $" + cantidadConvertida + " " + aDivisa+"\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}