package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String currency1 = "";
        String currency2 = "";
        String path = "https://v6.exchangerate-api.com/v6/7e4b903f1b12bc111e7cddf9/pair/";

        while (true) {
            System.out.println("Sea bienvenido(a) al Conversor de Moneda" + "\n");
            System.out.println("1. Dólar Americano (USD) => Peso Argentino (ARS)");
            System.out.println("2. Peso Argentino (ARS) => Dólar Americano (USD)");
            System.out.println("3. Dólar Americano (USD) => Real Brasileño (BRL)");
            System.out.println("4. Real Brasileño(BRL) => Dólar Americano (USD)");
            System.out.println("5. Dólar Americano (USD) => Peso Colombiano (COP)");
            System.out.println("6. Peso Colombiano (COP) => Dólar Americano (USD)");
            System.out.println("0. Salir"  + "\n");
            System.out.println("Seleccione la operación que va a realizar:");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    currency1 = "USD";
                    currency2 = "ARS";
                    path += currency1 + "/" + currency2;
                    break;

                case 2:
                    currency1 = "ARS";
                    currency2 = "USD";
                    path += currency1 + "/" + currency2;
                    break;

                case 3:
                    currency1 = "USD";
                    currency2 = "BRL";
                    path += currency1 + "/" + currency2;
                    break;

                case 4:
                    currency1 = "BRL";
                    currency2 = "USD";
                    path += currency1 + "/" + currency2;
                    break;

                case 5:
                    currency1 = "USD";
                    currency2 = "COP";
                    path += currency1 + "/" + currency2;
                    break;

                case 6:
                    currency1 = "COP";
                    currency2 = "USD";
                    path += currency1 + "/" + currency2;
                    break;

                default:
                    break;

            }

            if(option == 0){
                System.out.println("Has cerrado la aplicación");
                System.exit(0);
            }else {
                System.out.println("Ingrese el valor a convertir:");
                double amount = scanner.nextDouble();

                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(path + "/" + amount))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                Gson gson = new Gson();
                Conversion miConversion = gson.fromJson(json, Conversion.class);
                System.out.println(miConversion);


            }

        }


    }
}