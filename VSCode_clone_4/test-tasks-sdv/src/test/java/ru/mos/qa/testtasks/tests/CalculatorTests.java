package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {
    Calculator calculator = new Calculator();
    @Test
    public void isSumWork() {
        int result = calculator.sum(11, 3);
        assertEquals(14, result);
    }

    @Test
    public void isMinusWork() {
        int result = calculator.minus(14, 4);
        assertEquals(10, result);
    }

    @Test
    public void isDivideWork() {
        int result = calculator.divide(10, 2);
        assertEquals(5, result);
    }

    @Test
    public void isMultiplyWirk() {
        int result = calculator.multiply(5, 3);
        assertEquals(15, result);
    }
}
