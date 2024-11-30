package com.company.stockmanagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 * Clase para interactuar con la API de Alpha Vantage.
 * Esta clase proporciona métodos para obtener el precio actual de una acción
 * y el precio histórico de una acción en base a una fecha dada.
 * 
 * Se conecta a la API de Alpha Vantage y maneja las respuestas en formato JSON
 * para extraer los datos relevantes sobre el precio de las acciones.
 * 
 * @author Gabriel
 */
public class AlphaVantageAPI {

    // URL base de la API de Alpha Vantage
    private static final String API_URL = "https://www.alphavantage.co/query";
    private String apiKey;

    /**
     * Constructor de la clase AlphaVantageAPI.
     * 
     * @param apiKey la clave API para autenticar las solicitudes a Alpha Vantage.
     */
    public AlphaVantageAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Método para obtener el precio actual de una acción mediante la API de Alpha Vantage.
     * 
     * @param symbol el símbolo de la acción (por ejemplo, "AAPL" para Apple).
     * @return el precio actual de la acción o -1 si ocurre un error.
     */
    public double obtenerPrecioActual(String symbol) {
        // URL para la solicitud de datos intradía (últimos 1 minuto)
        String urlString = API_URL + "?function=TIME_SERIES_INTRADAY&symbol=" + symbol + "&interval=1min&apikey=" + apiKey;
        try {
            // Establecer la conexión HTTP
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer la respuesta de la API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Parsear la respuesta JSON
            JSONObject json = new JSONObject(content.toString());
            if (json.has("Time Series (1min)")) {
                // Obtener la serie de tiempo y extraer el precio de cierre del último minuto
                JSONObject timeSeries = json.getJSONObject("Time Series (1min)");
                String lastKey = timeSeries.keys().next();
                return timeSeries.getJSONObject(lastKey).getDouble("4. close");
            } else {
                System.out.println("Respuesta de la API: " + content.toString());
                System.out.println("Error: No se recibieron datos válidos.");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el precio actual: " + e.getMessage());
            return -1;
        }
    }

    /**
     * Método para obtener el precio histórico de una acción en una fecha específica.
     * 
     * @param symbol el símbolo de la acción (por ejemplo, "AAPL").
     * @param fecha la fecha en formato "yyyy-MM-dd" (por ejemplo, "2022-03-01").
     * @return el precio de la acción en la fecha especificada o -1 si ocurre un error.
     */
    public double obtenerPrecioHistorico(String symbol, String fecha) {
        // URL para la solicitud de datos históricos diarios
        String urlString = API_URL + "?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + apiKey;
        try {
            // Establecer la conexión HTTP
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer la respuesta de la API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Parsear la respuesta JSON
            JSONObject json = new JSONObject(content.toString());
            if (json.has("Time Series (Daily)")) {
                // Obtener la serie de tiempo diaria y buscar el precio en la fecha proporcionada
                JSONObject timeSeries = json.getJSONObject("Time Series (Daily)");
                if (timeSeries.has(fecha)) {
                    return timeSeries.getJSONObject(fecha).getDouble("4. close");
                } else {
                    System.out.println("Error: Fecha no encontrada.");
                    return -1;
                }
            } else {
                System.out.println("Respuesta de la API: " + content.toString());
                System.out.println("Error: No se recibieron datos válidos.");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el precio histórico: " + e.getMessage());
            return -1;
        }
    }
}
