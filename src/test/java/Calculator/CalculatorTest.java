package Calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"1,2,3", "3,5,8", "10,2,12", "25, 0, 25"})
    void add(String number1, String number2, String expected) {
        //given

        //when
        double result = Calculator.add(Double.parseDouble(number1), Double.parseDouble(number2));
        //then
        assertEquals(Double.parseDouble(expected), result);
    }

    @ParameterizedTest
    @MethodSource("provideSubArg")
    void subs(double number1, double number2, double expected) {
        //given

        //when
        double result = Calculator.subs(number1, number2);
        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ArgumentsSource(DivArgsProvider.class)
    void div(double number1, double number2, double expected) {
        //given

        //when
        double result = Calculator.div(number1, number2);
        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/multSource.csv")
    void multi(String number1, String number2, String expected) {
        //given

        //when
        double result = Calculator.multi(Double.parseDouble(number1), Double.parseDouble(number2));
        //then
        assertEquals(Double.parseDouble(expected), result);
    }

    private static Stream<Arguments> provideSubArg() {
        return Stream.of(
                Arguments.of(3, 2, 1),
                Arguments.of(5, 10, -5),
                Arguments.of(0, 2, -2),
                Arguments.of(100, 0, 100)
        );
    }
}