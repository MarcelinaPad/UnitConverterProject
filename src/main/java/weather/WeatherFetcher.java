package weather;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class WeatherFetcher {

    private HttpClient client;

    public WeatherFetcher(HttpClient client ){
        this.client = client;
    }
    private static final String API_KEY = "cd4ed1451e398ace8930a6b335fd8845";

    public WeatherDetails fetchWeather(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&units=metric";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();
            return parseWeatherData(jsonResponse);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error fetching weather data:" + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    private WeatherDetails parseWeatherData(String json) {
        Gson gson = new Gson();
        WeatherResponse weatherResponse = gson.fromJson(json, WeatherResponse.class);

        String cityName = weatherResponse.getName();
        double temperature = weatherResponse.getMain().getTemp();
        double feelsLike = weatherResponse.getMain().getFeels_like();
        int humidity = weatherResponse.getMain().getHumidity();
        String weatherDescription = weatherResponse.getWeather()[0].getDescription();

        return new WeatherDetails(cityName, temperature, feelsLike, humidity, weatherDescription);
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter city name to get the current weather: ");
        String city = scanner.nextLine();


      //  WeatherDetails weatherDetails = fetchWeather(city);

    }
}
