
# Algorithm Learning Notes
### Lesson1: Basic Algorithm
**(1)Quick Sort**<br>
Average performance: $O(nlogn)$<br>
Worst-case performance: $O(n^2)$
```java
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
        String[] arrStr = br.readLine().split("  ");  
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
```

**(2)Merge Sort**<br>
Avergae performance: $O(nlogn)$<br>
Worst performance: $O(nlogn)$
```java
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
  
public class MergeSort {  
    private static int[] arr = new int[100000];  
    private static int[] temp = new int[100000];  
  
    private static void mergeSort(int l, int r) {  
        if(l >= r) return;  
        int mid = (l + r) / 2;  
        //Use recursive sorting to sort the left and right segments of the array separately  
        mergeSort(l, mid);  
        mergeSort(mid + 1, r);  
        int k = 0, i = l, j = mid + 1;  
        while(i <= mid && j <= r) {  
            if(arr[i] < arr[j])  
                temp[k++] = arr[i++];  
            else  
	            temp[k++] = arr[j++];  
        }  
        while(i <= mid) temp[k++] = arr[i++];  
        while(j <= r) temp[k++] = arr[j++];  
        for (i = l, j = 0; i <= r; i++, j++) arr[i] = temp[j];  
    }  
  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int n = Integer.parseInt(br.readLine());  
        String[] aryStr = br.readLine().split("  ");  
        for (int i = 0; i < n; i++) {  
            arr[i] = Integer.parseInt(aryStr[i]);  
        }  
        mergeSort(0, n - 1);  
        for (int i = 0; i < n; i++) {  
            if (i < n - 1)  
                System.out.printf("%d ", arr[i]);  
            else  
	            System.out.println(arr[i]);  
        }  
    }  
}
```
