import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例.
    private static final List<TestCase> testCases = new ArrayList<TestCase>();
    private static void initializeTestCases(){
        testCases.clear();
        testCases.add(new TestCase(LocalDateTime.of(2025, 2, 16, 10, 0), 3));
        testCases.add(new TestCase(LocalDateTime.of(2025, 2, 16, 10, 0), 1));
        testCases.add(new TestCase(LocalDateTime.of(2025, 2, 16, 11, 0), 1));
        testCases.add(new TestCase(LocalDateTime.of(2024, 12, 31, 23, 59), 2));
        testCases.add(new TestCase(LocalDateTime.of(2025, 1, 1, 0, 0), 4));
        testCases.add(new TestCase(LocalDateTime.of(2025, 2, 16, 10, 0), 5));
        testCases.add(new TestCase(LocalDateTime.of(2024, 12, 31, 23, 59), 6));
        testCases.add(new TestCase(LocalDateTime.of(2025, 1, 1, 0, 0), 7));
        testCases.add(new TestCase(LocalDateTime.of(2025, 2, 16, 10, 0), 8));
        testCases.add(new TestCase(LocalDateTime.of(2024, 12, 31, 23, 59), 9));
        testCases.add(new TestCase(LocalDateTime.of(2025, 1, 14, 12, 0), 8));
        testCases.add(new TestCase(LocalDateTime.of(2025, 1, 1, 0, 0), 8));
    }

    // sortByDateTime方法: 先比较订单时间dateTime, 再比较订单桌号tableId.
    public static int sortByDateTime(TestCase CaseA, TestCase CaseB){
        int dateTimeCompare = CaseA.getDateTime().compareTo(CaseB.getDateTime());
        if(dateTimeCompare != 0)
            return dateTimeCompare;
        else
            return CaseA.getTableId().compareTo(CaseB.getTableId());
    }

    // sortByTableId方法: 先比较订单桌号tableId, 再比较订单时间dateTime.
    public static int sortByTableId(TestCase CaseA, TestCase CaseB){
        int tableIdCompare = CaseA.getTableId().compareTo(CaseB.getTableId());
        if(tableIdCompare != 0)
            return tableIdCompare;
        else
            return CaseA.getDateTime().compareTo(CaseB.getDateTime());
    }

    // printTestCases方法: 用于展示排序后的数组.
    private static void printTestCases(){
        for(TestCase Case : testCases)
            System.out.println(Case.show());
    }

    public static void main(String[] args) {

        // 归并排序
        initializeTestCases();
        MergeSort.mergeSort(testCases, 0, testCases.size() - 1, Main::sortByDateTime);
        System.out.println("(1) The result of MergeSort: ");
        printTestCases();
        System.out.println();

        // 快速排序
        initializeTestCases();
        QuickSort.quickSort(testCases, 0, testCases.size() - 1, Main::sortByDateTime);
        System.out.println("(2) The result of QuickSort: ");
        printTestCases();
        System.out.println();

        // 堆排序
        initializeTestCases();
        HeapSort.heapSort(testCases, Main::sortByDateTime);
        System.out.println("(3) The result of HeapSort: ");
        printTestCases();
        System.out.println();
    }
}