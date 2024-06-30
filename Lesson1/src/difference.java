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
