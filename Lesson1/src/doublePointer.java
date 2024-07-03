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
