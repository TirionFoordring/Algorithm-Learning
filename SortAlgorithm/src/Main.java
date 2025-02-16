import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例.
    public static List<TestCase> testCases = new ArrayList<TestCase>();
    private static void initializeTestCases(){
        testCases.add(new TestCase(LocalDateTime.of(2025, 2, 16, 10, 0), 3));
        testCases.add(new TestCase(LocalDateTime.of(2025, 2, 16, 10, 0), 1));
        testCases.add(new TestCase(LocalDateTime.of(2024, 12, 31, 23, 59), 2));
        testCases.add(new TestCase(LocalDateTime.of(2025, 1, 1, 0, 0), 4));
        testCases.add(new TestCase(LocalDateTime.of(2025, 2, 16, 10, 0), 5));
        testCases.add(new TestCase(LocalDateTime.of(2024, 12, 31, 23, 59), 6));
        testCases.add(new TestCase(LocalDateTime.of(2025, 1, 1, 0, 0), 7));
        testCases.add(new TestCase(LocalDateTime.of(2025, 2, 16, 10, 0), 8));
        testCases.add(new TestCase(LocalDateTime.of(2024, 12, 31, 23, 59), 9));
        testCases.add(new TestCase(LocalDateTime.of(2025, 1, 1, 0, 0), 10));
    }

    // compare方法: 用于比较两个测试案例的大小关系, 先比较订单时间dateTime, 再比较订单桌号tableId.
    public static int compare(TestCase CaseA, TestCase CaseB){
        int dateTimeCompare = CaseA.getDateTime().compareTo(CaseB.getDateTime());
        if(dateTimeCompare != 0)
            return dateTimeCompare;
        else
            return CaseA.getTableId().compareTo(CaseB.getTableId());
    }

    // printTestCases方法: 用于展示排序后的数组.
    private static void printTestCases(){
        for(TestCase Case : testCases)
            System.out.println(Case.show());
    }

    public static void main(String[] args) {
        initializeTestCases();

        if(testCases == null || testCases.isEmpty()){
            System.out.println("Test cases is not existed.");
        }

        if(testCases.size() == 1){
            System.out.println(testCases.get(0).show());
        }

        MergeSort.mergeSort(testCases, 0, testCases.size() - 1);
        printTestCases();
    }
}