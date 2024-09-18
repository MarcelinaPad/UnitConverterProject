package converter;

import java.util.Scanner;

public class UnitConverter {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your conversion options: ");
        System.out.println("1. Kilometers to miles ");
        System.out.println("2. Miles to kilometers ");
        System.out.println("3. Celsius to Fahrenheit ");
        System.out.println("4. Fahrenheit to Celsius ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Kilometers to miles conversion selected");
                System.out.println("Enter the number of kilometers");
                double kilometers = scanner.nextDouble();
                double miles = kilometers * 0.621371;
                System.out.println(kilometers + " kilometers is " + miles + " miles");
                break;

            case 2:
                System.out.println("Miles to kilometers conversion selected ");
                System.out.println("Enter the number of miles");
                miles = scanner.nextDouble();
                kilometers = miles * 1.6093;
                System.out.println(miles + " miles is " + kilometers + " kilometers ");
                break;


            case 3:
                System.out.println("Celsius to Fahrenheit conversion selected");
                System.out.println("Enter the number of degrees Celsius");
                double celsius = scanner.nextDouble();
                double fahrenheit = (celsius * 9 / 5) + 32;
                System.out.println(celsius + " C is " + fahrenheit + " F");
                break;

            case 4:
                System.out.println("Farenheit to celsius conversion selected");
                System.out.println("Enter the number of degrees Fahrenheit");
                fahrenheit = scanner.nextDouble();
                celsius = (fahrenheit - 32) * 5 / 9;
                System.out.println(fahrenheit + " Fahrenheit is " + celsius + " Celsius");
                break;

            default:
                System.out.println("Incorrect choice");
        }
        scanner.close();
    }
}
