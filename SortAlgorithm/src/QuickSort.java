import java.util.List;

public class QuickSort {
    public static void quickSort(List<TestCase> testCases, int l, int r) {
        if ( l >= r ) return;
        TestCase p = testCases.get((l + r) / 2);
        int i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (Main.sortByDateTime(testCases.get(i), p) < 0);
            do {
                j--;
            } while (Main.sortByDateTime(testCases.get(j), p) > 0);
            if (i < j) {
                TestCase temp = testCases.get(i);
                testCases.set(i, testCases.get(j));
                testCases.set(j, temp);
            }
        }
        quickSort(testCases, l, j);
        quickSort(testCases, j + 1, r);
    }
}
