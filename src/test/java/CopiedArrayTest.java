import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CopiedArrayTest {
    @Test
    public void verifyArraysLength() {
        int[] array1 = new int[10];
        int[] array2 = Arrays.copyOf(array1, 5);
        Assert.assertEquals(array1.length, array2.length);
    }
}
