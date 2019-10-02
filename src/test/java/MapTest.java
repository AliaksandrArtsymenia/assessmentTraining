import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class MapTest extends CommonCondition{
    @Parameters({"expectedValueOfFirstMapItem"})
    @Test
    public void assertMap(String expectedValue) {
        for (Map.Entry<Integer, String> entry : testMap.entrySet()) {
            System.out.printf("key: %d, value: %s\t", entry.getKey(), entry.getValue());
        }
        Assert.assertEquals(testMap.get(0), expectedValue);
    }
}
