import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FactorialTest {
    private int getFactorial(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        else return n * getFactorial(n - 1);
    }

    @ParameterizedTest
    @MethodSource("getNForFactorial")
    void checkFactorial(int n) {
        int expectedValue = 24;
        Assertions.assertEquals(expectedValue, getFactorial(n), "message");
    }

    static Stream<Integer> getNForFactorial() {
        return Stream.of(4);
    }
//    static Stream<Person> getNForFactorial() {
//        return Stream.of(new Person("Petaya", 12, "Male"));
//    }
}
