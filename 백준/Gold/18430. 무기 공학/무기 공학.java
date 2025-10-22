import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer = 0;
    static int[][] map;
    static boolean[][] used;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상우하좌

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        used = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(0, 0);

        System.out.println(answer);
    }

    static void find(int sum, int lastRow) {
        answer = Math.max(answer, sum);

        for (int i = lastRow; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (used[i][j]) continue;

                // 부메랑 모양별로 확인하기
                for (int k = 0; k < 4; k++) {
                    int nR1 = i + dir[k][0];
                    int nC1 = j + dir[k][1];
                    // 사용할 모양 중 한쪽이 사용중이거나 범위를 넘어갈 때
                    if (nR1 >= N || nR1 < 0 || nC1 >= M || nC1 < 0 || used[nR1][nC1]) {
                        continue;
                    }

                    int dIDx = (k + 1) % 4;
                    int nR2 = i + dir[dIDx][0];
                    int nC2 = j + dir[dIDx][1];
                    if (nR2 >= N || nR2 < 0 || nC2 >= M || nC2 < 0 || used[nR2][nC2]) {
                        continue;
                    }

                    used[nR1][nC1] = true;
                    used[nR2][nC2] = true;
                    used[i][j] = true;
                    int nextSum = sum + map[nR1][nC1] + map[nR2][nC2] + (map[i][j] * 2);

                    find(nextSum, i);

                    used[nR1][nC1] = false;
                    used[nR2][nC2] = false;
                    used[i][j] = false;
                }

            }
        }
    }

}
