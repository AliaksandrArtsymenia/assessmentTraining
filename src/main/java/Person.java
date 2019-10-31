import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.Set;

@Value
@Builder(toBuilder = true)
public class Person implements Comparable<Person> {
    @Builder.Default
    private String name = "Mr/Ms";
    private Integer age;
    private String sex;
    @Singular(value = "null")
    private Set<String> any;

    @Override
    public int compareTo(Person person) {
        return this.getAge().compareTo(person.getAge());
    }
}
