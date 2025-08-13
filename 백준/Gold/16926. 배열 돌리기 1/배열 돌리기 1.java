import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R, row, col;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        N = row;
        M = col;
        int min = Math.min(N, M) / 2;
        for (int i = 0; i < min; i++) {
            // 총 회전수를 둘레의 길이로 나눈 나머지만큼만 가면 됨
            int rotateNum = R % ((N + M) * 2 - 4);
            for (int j = 0; j < rotateNum; j++) {
                rotate(i, i);
            }
            N -= 2;
            M -= 2;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    static void rotate(int startRow, int startCol) {
        // <-
        int top = startRow;
        int bottom = startRow + N - 1;
        int left = startCol;
        int right = startCol + M - 1;

        int temp = arr[startRow][startCol];
        for (int i = left; i < right; i++) {
            arr[startRow][i] = arr[startRow][i + 1];
        }

        // up
        for (int i = top; i < bottom; i++) {
            arr[i][right] = arr[i + 1][right];
        }

        // ->
        for (int i = right; i > left; i--) {
            arr[bottom][i] = arr[bottom][i - 1];
        }

        // down
        for (int i = bottom; i > top; i--) {
            arr[i][left] = arr[i - 1][left];
        }

        arr[top + 1][left] = temp;

    }

}
