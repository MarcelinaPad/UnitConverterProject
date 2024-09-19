package weather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class WetherFetcherTest {
    private WeatherFetcher weatherFetcher;
    private HttpClient mockHttpClient;

    @BeforeEach
    public void setup() {
        mockHttpClient = mock(HttpClient.class);
        weatherFetcher = new WeatherFetcher(mockHttpClient);
    }

    @Test

    public void testFetcherWeather() throws Exception {
        //Given mamy dane, fałszywą odpowiedź JSON z API

        HttpResponse<String> mockResponse = mock(HttpResponse.class);
        String jsonResponse = """
                {
                "main": {
                "temp": 15.32,
                "feels_like": 14.28,
                "humidity": 77
                },
                "weather": [{
                "description": "overcast clouds"
                }],
                "name": "London"
                }
                """;

        //When wywołujemy metodę , mockujemy odpowiedź z http

        when(mockResponse.body()).thenReturn(jsonResponse);
        when(mockHttpClient.send( any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(mockResponse);

        //Then sprawdzamy czy wynik jest prawidłowy
        WeatherDetails expectedWeather = new WeatherDetails(
                "London", 15.32, 14.28, 77, "overcast clouds"
        );
        WeatherDetails actualDetails = weatherFetcher.fetchWeather("London");

        assertEquals(expectedWeather, actualDetails);

    }

}
