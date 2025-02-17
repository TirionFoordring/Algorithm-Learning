import java.util.Comparator;
import java.util.List;

public class QuickSort {
    public static void quickSort(List<TestCase> testCases, int l, int r, Comparator<TestCase> comparator) {
        if ( l >= r ) return;
        TestCase p = testCases.get((l + r) / 2);
        int i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (comparator.compare(testCases.get(i), p) < 0);
            do {
                j--;
            } while (comparator.compare(testCases.get(j), p) > 0);
            if (i < j) {
                TestCase temp = testCases.get(i);
                testCases.set(i, testCases.get(j));
                testCases.set(j, temp);
            }
        }
        quickSort(testCases, l, j, comparator);
        quickSort(testCases, j + 1, r, comparator);
    }
}
