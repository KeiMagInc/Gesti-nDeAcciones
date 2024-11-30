/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.stockmanagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Clase para interactuar con la API de Alpha Vantage
public class AlphaVantageAPI {

    private static final String API_URL = "https://www.alphavantage.co/query";
    private String apiKey;

    public AlphaVantageAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    // Método para obtener el precio actual de una acción
    public double obtenerPrecioActual(String symbol) {
        String urlString = API_URL + "?function=TIME_SERIES_INTRADAY&symbol=" + symbol + "&interval=1min&apikey=" + apiKey;
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(content.toString());
            if (json.has("Time Series (1min)")) {
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

    // Método para obtener el precio histórico de una acción
    public double obtenerPrecioHistorico(String symbol, String fecha) {
        String urlString = API_URL + "?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + apiKey;
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(content.toString());
            if (json.has("Time Series (Daily)")) {
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
