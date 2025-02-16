import java.util.ArrayList;
import java.util.List;

// 使用归并排序实现对于测试用例中的所有示例排序.
public class MergeSort {
    public static void mergeSort(List<TestCase> testCases, int l, int r){
        if (l >= r) return;
        int mid = (l + r) / 2;

        mergeSort(testCases, l, mid);
        mergeSort(testCases, mid + 1, r);

        // 创建临时数组.
        List<TestCase> temp = new ArrayList<>();

        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r){
            if (Main.sortByDateTime(testCases.get(i), testCases.get(j)) < 0)
                temp.add(k++, testCases.get(i++));
            else
                temp.add(k++, testCases.get(j++));
        }
        while (i <= mid) temp.add(k++, testCases.get(i++));
        while (j <= r) temp.add(k++, testCases.get(j++));

        // 还原现场
        for (i = l, j = 0; i <= r; i++, j++) testCases.set(i, temp.get(j));
    }
}
