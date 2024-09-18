package converter;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitConverterTest {
    @Test
    public void testKilometersToMiles(){
        double kilometers = 10;
        double expectedMiles = 6.21371;
        double result = kilometers * 0.621371;
        assertEquals(expectedMiles, result, 0.00001);
    }

    @Test
    public void testMilesToKilometers() {
        double miles = 5;
        double expectedKilometers = 8.0467;
        double result = miles * 1.6093;
        assertEquals(expectedKilometers, result, 0.0002);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        double celsius = 0;
        double expectedFahrenheit = 32;
        double result = (celsius * 9/5) + 32;
        assertEquals(expectedFahrenheit, result, 0.0001);
    }

    @Test
    public void testFahrenheitToCelsius() {
        double fahrenheit = 32;
        double expectedCelsius = 0;
        double result = (fahrenheit - 32) * 5/9;
        assertEquals(expectedCelsius, result, 0.0001);
    }
}
