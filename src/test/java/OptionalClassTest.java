import org.testng.annotations.Test;

import java.util.Optional;

public class OptionalClassTest {
    @Test
    public void verifyOptional() {
        Optional<Person> optionalPerson = Optional.of(returnSecondPerson());
        Person secondPerson = optionalPerson.isPresent() ? optionalPerson.get() : new Person("", 0, "");
        int ageOfSecondPerson = optionalPerson.map(Person::getAge).get();
        System.out.println(secondPerson);
    }

    private Person returnSecondPerson() {
        CollectionsTraining collectionsTraining = new CollectionsTraining();
        return collectionsTraining.generateListOfPerson().get(1);
    }
}
