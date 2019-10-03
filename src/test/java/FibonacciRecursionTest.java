import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FibonacciRecursionTest {
    private int getFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }

    @Test
    public void testFib() {
        int[] arr = new int[6];
        int[] expectedArray = new int[]{1, 1, 2, 3, 5, 8};
        for (int i=0; i<6; i++) {
            arr[i] = getFibonacci(i);
        }
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
        Arrays.stream(expectedArray).forEach(System.out::print);
        Assert.assertEquals(arr, expectedArray);
    }
}
