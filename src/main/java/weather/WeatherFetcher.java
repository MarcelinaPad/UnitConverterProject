package weather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class WeatherFetcher {

    private static final String API_KEY = "cd4ed1451e398ace8930a6b335fd8845";

    public static void fetchWeather(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&units=metric";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Weather data for " + city + ": " + response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println("Error fetching weather data:" + e.getMessage());
        }
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter city name to get the current weather: ");
        String city = scanner.nextLine();


        fetchWeather(city);
    }
}
