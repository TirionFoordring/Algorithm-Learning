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