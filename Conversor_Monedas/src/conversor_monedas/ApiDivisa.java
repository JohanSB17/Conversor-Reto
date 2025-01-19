/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor_monedas;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiDivisa {
    public double get(String cantidadDinero, String deDivisa, String aDivisa) {
        double indicedeConversion = 0;
        double cantidad = Double.parseDouble(cantidadDinero);
        String APIKey = "2a63c3f4fb9b9248e0983a27";

        try {
            // Construir la URL de la API con los parámetros de conversión
            URL url = new URL("https://v6.exchangerate-api.com/v6/" + APIKey + "/pair/" + deDivisa + "/" + aDivisa + "/" + cantidad);

            // Establecer la conexión HTTP
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Verificar el código de respuesta HTTP
            if (request.getResponseCode() == 200) {
                // Analizar la respuesta JSON
                JsonObject respuesta = JsonParser.parseReader(new InputStreamReader(request.getInputStream())).getAsJsonObject();
                // Verificar si los elementos necesarios no son nulos
                if (respuesta.has("conversion_result")) {
                    indicedeConversion = respuesta.get("conversion_result").getAsDouble();
                } else {
                    System.out.println("La respuesta JSON no tiene los elementos esperados.");
                }
            } else {
                System.out.println("Error de Respuesta " + request.getResponseCode());
            }
            // Cerrar la conexión HTTP
            request.disconnect();

        } catch (MalformedURLException e) {
            System.out.println("URL mal formada: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de IO: " + e.getMessage());
        }

        return indicedeConversion;
    }

}

