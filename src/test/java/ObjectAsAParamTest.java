import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class ObjectAsAParamTest {
    @Test(dataProvider = "returnPerson")
    public void checkPerson(Person expectedPerson) {
        List<Person> list = new CollectionsTraining().generateListOfPerson();
        Assert.assertEquals(list.get(0), expectedPerson);

    }

    @DataProvider(name = "returnPerson")
    private Object[] getData() {
        return new Object[] {
                new Person("Viktor", 22, "Male")
        };
    }
}
