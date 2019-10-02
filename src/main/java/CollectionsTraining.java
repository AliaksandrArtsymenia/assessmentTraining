import java.util.*;

public class CollectionsTraining {
    public List<String> generateList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Blue");
        list.addLast("Yellow");
        list.offerLast("Green");
        list.add("Red");
        System.out.println(list);
        return list;
    }

    public Map<Integer, String> generateMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(8, "Eight");
        map.put(1, "One");
        map.put(2, "two");
        map.put(0, "zero");
        System.out.println(map.toString());
        return map;
    }

    public List<Person> generateListOfPerson() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Vasya", 22, "Male"));
        list.add(new Person("Petya", 20, "Male"));
        list.add(new Person("Katya", 28, "Female"));
        return list;
    }
}
