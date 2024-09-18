package weather;

public class WeatherResponse {
    private MainWeather main;
    private WeatherDescription[] weather;
    private String name;


    public MainWeather getMain() {
        return main;
    }

    public WeatherDescription[] getWeather() {
        return weather;
    }

    public String getName() {
        return name;
    }
}