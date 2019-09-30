import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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
}
