import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class ClassVerificationTest extends CommonCondition {
    @Test
    public void verifyCollectionClass() {
        Assert.assertEquals(collection.getClass(), LinkedList.class);
    }
}
