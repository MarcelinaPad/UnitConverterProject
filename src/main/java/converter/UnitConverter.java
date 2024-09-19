package converter;

import weather.WeatherDetails;
import weather.WeatherFetcher;

import java.net.http.HttpClient;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UnitConverter {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {

                System.out.println("Choose your conversion options: ");
                System.out.println("1. Kilometers to miles ");
                System.out.println("2. Miles to kilometers ");
                System.out.println("3. Celsius to Fahrenheit ");
                System.out.println("4. Fahrenheit to Celsius ");
                System.out.println("5. Get current weather");

                int choice = scanner.nextInt();
                validInput = true;

                switch (choice) {

                    case 1:
                        convertKilometersToMiles(scanner);
                        break;
                    case 2:
                        convertMilesToKilometers(scanner);
                        break;
                    case 3:
                        convertCelsiusToFahrenheit(scanner);
                        break;
                    case 4:
                        convertFahrenheitToCelsius(scanner);
                        break;

                    case 5:
                        System.out.println("Enter the city name: ");
                        String city = scanner.next();
                        HttpClient httpClient = HttpClient.newHttpClient();
                        WeatherDetails weatherDetails = new WeatherFetcher(httpClient).fetchWeather(city);
                        System.out.println(weatherDetails.toString());
                        break;
                    default:
                        System.out.println("Incorrect choice. Please enter a valid option.");
                        validInput = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        scanner.close();
    }


    private void convertKilometersToMiles(Scanner scanner) {
        try {
            System.out.println("Enter the number of kilometers");
            double kilometers = scanner.nextDouble();
            double miles = kilometers * 0.621371;
            System.out.println(kilometers + " kilometers is " + miles + " miles");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }


    private void convertMilesToKilometers(Scanner scanner) {
        try {
            System.out.println("Enter the number of miles");
            double miles = scanner.nextDouble();
            double kilometers = miles * 1.6093;
            System.out.println(miles + " miles is " + kilometers + " kilometers ");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }


    private void convertCelsiusToFahrenheit(Scanner scanner) {
        try {
            System.out.println("Enter the number of degrees Celsius");
            double celsius = scanner.nextDouble();
            double fahrenheit = (celsius * 9 / 5) + 32;
            System.out.println(celsius + " C is " + fahrenheit + " F");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }


    private void convertFahrenheitToCelsius(Scanner scanner) {
        try {
            System.out.println("Enter the number of degrees Fahrenheit");
            double fahrenheit = scanner.nextDouble();
            double celsius = (fahrenheit - 32) * 5 / 9;
            System.out.println(fahrenheit + " F is " + celsius + " C");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }
}