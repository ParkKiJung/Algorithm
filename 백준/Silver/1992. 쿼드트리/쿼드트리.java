import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        find(0, 0, N, map[0][0]);

        System.out.println(sb.toString());
    }

    static void find(int startRow, int startCol, int size, char val) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[startRow + i][startCol + j] != val) {
                    sb.append("(");
                    find(startRow, startCol, size / 2, map[startRow][startCol]);
                    find(startRow, startCol + size / 2, size / 2, map[startRow][startCol + size / 2]);
                    find(startRow + size / 2, startCol, size / 2, map[startRow + size / 2][startCol]);
                    find(startRow + size / 2, startCol + size / 2, size / 2, map[startRow + size / 2][startCol + size / 2]);
                    sb.append(")");
                    return;
                }
            }
        }

        sb.append(val);

    }
}
