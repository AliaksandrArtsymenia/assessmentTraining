public class SortingTest {
    private int[] sortArray(int[] arr) {
        int current;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    isSorted = false;
                    current = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = current;
                }
            }
        }
        return arr;
    }
}
