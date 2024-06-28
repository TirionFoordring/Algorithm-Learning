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

**(3)Binary Search**
```java
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
```

**(4)BigInteger Calculate**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BigIntegerCalculate{
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void bigIntegerAdd() throws IOException {
        BigInteger bigInteger1 = new BigInteger(br.readLine());
        BigInteger bigInteger2 = new BigInteger(br.readLine());
        System.out.println(bigInteger1 + " + " + bigInteger2 + " = " + bigInteger1.add(bigInteger2));
    }

    private static void bigIntegerSubtract() throws IOException {
        BigInteger bigInteger1 = new BigInteger(br.readLine());
        BigInteger bigInteger2 = new BigInteger(br.readLine());
        System.out.println(bigInteger1 + " - " + bigInteger2 + " = " + bigInteger1.subtract(bigInteger2));
    }

    private static void bigIntegerMultiply() throws IOException {
        BigInteger bigInteger = new BigInteger(br.readLine());
        long smallInput = Long.parseLong(br.readLine());
        System.out.println(bigInteger + " * " + smallInput + " = " + bigInteger.multiply(BigInteger.valueOf(smallInput)));
    }

    private static void bigIntegerDivide() throws IOException {
        BigInteger bigInteger = new BigInteger(br.readLine());
        long smallInput = Long.parseLong(br.readLine());
        BigInteger result = bigInteger.divide(BigInteger.valueOf(smallInput));
        BigInteger remainder = bigInteger.remainder(BigInteger.valueOf(smallInput));
        System.out.println(bigInteger + " / " + smallInput + ": ");
        System.out.println("result = " + result);
        System.out.println("remainder = " + remainder);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Input \"+\", \"-\", \"*\" or \"/\" to select calculation.");
        String input = br.readLine();
        if (input.equals("+")) {
            bigIntegerAdd();
        } else if (input.equals("-")) {
            bigIntegerSubtract();
        } else if (input.equals("*")) {
            bigIntegerMultiply();
        } else if (input.equals("/")) {
            bigIntegerDivide();
        } else {
            System.out.println("Invalid input");
        }
    }
}
```