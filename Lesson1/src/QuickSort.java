import java.io.*;

public class QuickSort {
    private static int[] arr = new int[100000];

    private static void quickSort(int l, int r) {
        if (l >= r) return;
        int pivot = arr[(l+r)/2];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        quickSort(l, j);
        quickSort(j + 1, r);
    }

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        quickSort(0, n - 1);
        for (int i = 0; i < n; i++) {
            if (i < n - 1){
                System.out.print(arr[i] + " ");
            }
            else{
                System.out.print(arr[i]);
            }
        }
    }
}