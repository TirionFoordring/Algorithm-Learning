import java.util.HashSet;
import java.util.Set;

public class deadWeight {
    public static int[] unique(int[] arr){
        Set<Integer> set = new HashSet<Integer>();
        for (int num : arr){
            set.add(num);
        }
        int[] uniqueArr = new int[set.size()];
        int i = 0;
        for (int num : set){
            uniqueArr[i++] = num;
        }
        return uniqueArr;
    }
}
