import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyElementTest extends CommonCondition {
    @Test(groups = "Negative")
    public void verifyElement() {
        if (collection.get(1).equals("Blue")) {
            try {
                throw new SpecialException("Unexpected color");
            } catch (SpecialException e) {
                e.printStackTrace();
            }
        }
        Assert.assertEquals(collection.get(1), "Black");
    }
}
