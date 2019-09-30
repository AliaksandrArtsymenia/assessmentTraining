import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListTraining {
    List<String> list = new ArrayList<>();
    public String str = "qwerty";

    public void outList(List<String> list) {
        list = new ArrayList<>();
        list.add("Red");
        list.add("Blue");
        System.out.println(list);

        list.add(0,"White");
        list.forEach(System.out::println);

        list.set(0, "Black");

        System.out.println("sorted"+ list.stream().sorted().collect(Collectors.toList()));

        list.remove(2);
        System.out.println(list +" size = "+ list.size());

        list.add("Black");
        System.out.println(searchForElement(list, "Black"));

        Collections.shuffle(list);
        System.out.println("Copied shuffled list"+ new ArrayList<>(list));

        Collections.reverse(list);
        System.out.println("Reversed list "+ list);



    }

    private int searchForElement(List<String> list, String element) {
        return (int) list.stream().filter(x -> x.equals(element)).count();
    }
}
