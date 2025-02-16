import java.util.List;

public class HeapSort {
    public static void heapSort(List<TestCase> testCases) {
        int n = testCases.size();
        // 构建大根堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(testCases, n, i);
        }
        // 排序
        for (int i = n - 1; i > 0; i--) {
            // 将堆顶元素（最大值）与堆的最后一个元素交换
            TestCase temp = testCases.get(0);
            testCases.set(0, testCases.get(i));
            testCases.set(i, temp);

            // 调整剩余部分为最大堆
            heapify(testCases, i, 0);
        }
    }

    // 将数组调整成一个大根堆
    private static void heapify(List<TestCase> testCases, int n, int i){
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // 判断左子节点是否大于根节点.
        if (l < n && Main.sortByDateTime(testCases.get(largest), testCases.get(l)) < 0){
            largest = l;
        }

        // 判断右子节点是否大于根节点.
        if (r < n && Main.sortByDateTime(testCases.get(largest), testCases.get(r)) < 0){
            largest = r;
        }

        // 若最大值不是根节点, 将最大值交换到根节点上去.
        if (largest != i){
            TestCase temp = testCases.get(i);
            testCases.set(i, testCases.get(largest));
            testCases.set(largest, temp);

            // 将下方所有受影响的子树递归调整.
            heapify(testCases, n, largest);
        }
    }
}
