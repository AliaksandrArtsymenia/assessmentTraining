import org.testng.annotations.Test;

public class LombokTest {
    @Test
    public void checkLombok() {
        Person person = Person.builder().age(12).sex("Male").build();
        System.out.println(person);
    }
}
