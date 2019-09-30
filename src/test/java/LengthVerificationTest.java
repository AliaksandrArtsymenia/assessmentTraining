import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LengthVerificationTest extends CommonCondition{
    @Test(groups = "Negative", dataProvider = "Parameters")
    @Parameters("expectedSize")
    public void verifySize(int expectedSize, boolean isEmpty) {
        new SoftAssert().assertEquals(collection.isEmpty(), isEmpty);
        Assert.assertEquals(collection.size(), expectedSize);
    }

    @DataProvider(name = "Parameters", parallel = true)
    private static Object[][] values() {
        return new Object[][] {
                {6, true},
                {5, false}
        };
    }
}
