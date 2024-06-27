import java.io.*;

public class QuickSort {

    private static void quickSort(int[] arr, int l, int r) {
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
        quickSort(arr, l, j);
        quickSort(arr, j + 1, r);
    }

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        String[] arrStr = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        quickSort(arr, 0, n - 1);
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