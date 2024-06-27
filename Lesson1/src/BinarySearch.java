import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {
    private static void binarySearch(int[] arr, int l, int r, int key){
        int res = -1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > key) {
                r = mid - 1;
            } else if (arr[mid] < key) {
                l = mid + 1;
            } else {
                res = mid;
                break;
            }
        }
        if (res == -1) {
            System.out.println("Key not found!");
        } else {
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int key = Integer.parseInt(str[1]);
        int[] arr = new int[n];
        String[] arrStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        binarySearch(arr, 0, n - 1, key);
    }
}
