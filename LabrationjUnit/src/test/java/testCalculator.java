import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class testCalculator {
    private Calculator calc;

    @BeforeEach
    void beforeTest() {
        calc = new Calculator();
        System.out.println("Begin test!");
    }

    @AfterEach
    void afterTest() {
        calc = null;
        System.out.print("Test completed!");
    }

    @Test
    @Order(1)
    @Tag("Fast")
    @DisplayName("Secret, do not read!")
    void howManyKenoNumbersDoIPlayWith() {
        assertEquals(true, calc.checkMyKeno(6));
    }

    @RepeatedTest(4)
    @Order(2)
    @Tag("Slow")
    void testCalculatorAddingWithSpecifiedNumbers(RepetitionInfo repInfo) {
        System.out.println("Repeated test nr: " + repInfo.getCurrentRepetition());
        assertEquals(6, calc.adding(2, 4));
        assertDoesNotThrow(()->calc.adding(4,2));

    }

    @ParameterizedTest
    @Order(3)
    @Tag("Fast")
    @CsvSource(value = {"1:3:3", "2:2:4", "3:5:15", "10:2:20", "4:0:0"}, delimiter = ':')
    void multiply_testingIfMultiplyIsCorrect(int first, int second, int expected) {
        assertEquals(expected, calc.multiply(first, second));
    }

    @Test()
    @Order(4)
    @Tag("Slow")
    @DisplayName("Exception is thrown when divided by 0")
    void divisionTest() {
        assertEquals(5, calc.division(10, 2));
        assertThrows(ArithmeticException.class, () -> { calc.division(1,0); });
        assertDoesNotThrow(()->calc.division(2,1));

    }

    @AfterAll
    static void done() {
        System.out.println("@AfterAll - All tests done!");
        System.out.println("Are we ready for deployment?");
    }
}

