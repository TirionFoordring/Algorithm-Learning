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

**(5)preSum**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class preSum {
    private final static int[] arr = new int[100010];
    private final static int[] preSum = new int[100010];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] arrStr = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(arrStr[i - 1]);
        }
        preSum[0] = 0;

        //formula of preSum: preSum[i] = preSum[i - 1] + arr[i]
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }

        for (int i = 0; i < m; i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]);
            int r = Integer.parseInt(lr[1]);
            System.out.println(preSum[r] - preSum[l - 1]);
        }
    }
}

class matrixPreSum{
    private final static int[][] matrix = new int[1010][1010];
    private final static int[][] preSum = new int[1010][1010];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmq = br.readLine().split(" ");
        int n = Integer.parseInt(nmq[0]);
        int m = Integer.parseInt(nmq[1]);
        int q = Integer.parseInt(nmq[2]);
        for (int i = 1; i <= n; i++) {
            String[] rowStr = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = Integer.parseInt(rowStr[j - 1]);
            }
        }

        //The matrix of preSum.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                preSum[i][j] += preSum[i][j - 1] + preSum[i - 1][j] - preSum[i - 1][j - 1] + matrix[i][j];
            }
        }

        //the sum of all numbers in any subMatrix
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String[] xy = br.readLine().split(" ");
            int x1 = Integer.parseInt(xy[0]);
            int y1 = Integer.parseInt(xy[1]);
            int x2 = Integer.parseInt(xy[2]);
            int y2 = Integer.parseInt(xy[3]);
            result.append(preSum[x2][y2] - preSum[x2][y1 - 1] - preSum[x1 - 1][y2] + preSum[x1 - 1][y1 - 1]).append("\n");
        }
        System.out.print(result);
    }
}
```

**(6)difference**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class difference {
    private static int[] arr = new int[100010];

    private static void add(int l, int r, int c){
        arr[l] += c;
        arr[r + 1] -= c;
    }

    public static void main(String[] args)  throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] arrStr = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            add(i, i, Integer.parseInt(arrStr[i - 1]));
        }
        for (int i = 0; i < m; i++) {
            String[] lrc = br.readLine().split(" ");
            int l = Integer.parseInt(lrc[0]);
            int r = Integer.parseInt(lrc[1]);
            int c = Integer.parseInt(lrc[2]);
            add(l, r, c);
        }
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            if (i != n) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.println(arr[i]);
            }
        }
    }
}

class matrixDifference {
    private static int[][] matrix = new int[1010][1010];

    private static void add(int x1, int y1, int x2, int y2, int c){
        matrix[x1][y1] += c;
        matrix[x2 + 1][y1] -= c;
        matrix[x1][y2 + 1] -= c;
        matrix[x2 + 1][y2 + 1] += c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmq = br.readLine().split(" ");
        int n = Integer.parseInt(nmq[0]);
        int m = Integer.parseInt(nmq[1]);
        int q = Integer.parseInt(nmq[2]);
        for (int i = 1; i <= n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 1; j <= m; j++)
                add(i, j, i, j, Integer.parseInt(str[j - 1]));
        }
        for (int i = 0; i < q; i++) {
            String[] str = br.readLine().split(" ");
            int x1 = Integer.parseInt(str[0]);
            int y1 = Integer.parseInt(str[1]);
            int x2 = Integer.parseInt(str[2]);
            int y2 = Integer.parseInt(str[3]);
            int c = Integer.parseInt(str[4]);
            add(x1, y1, x2, y2, c);
        }

        //Restore the original matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matrix[i][j] += matrix[i][j - 1] + matrix[i - 1][j] - matrix[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j != m) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.println(matrix[i][j]);
                }
            }
        }
    }
}
```

**(7)Double Pointer**<br>
Double pointer algorithm can improve the performance from $O(n^2)$ to $O(n)$
```java
// Question:
// Given an array of integers of length n,
// please find the longest continuous interval that does not contain duplicate numbers and output its length.
// Each number in the array is between 0 and 100000.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class doublePointer {
    private static int[] s = new int[100010];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int res = 1;
        for (int i = 0, j = 0; i < n; i++) {
            s[arr[i]]++;
            while (s[arr[i]] > 1) {
                s[arr[j]]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        System.out.println(res);
    }
}
```

**(8)Dead Weight**<br>
Remove all duplicate elements from an array and retaining only the position where each element first appears.
```java
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
```