import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<Integer>[] edges;
    static int[][] dp;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        dfs(1); // 1번 정점을 임의의 루트로 설정하여 DFS 시작

        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static void dfs(int cur) {
        visited[cur] = true;
        dp[cur][0] = 0; // cur이 얼리 어답터 아닐 때
        dp[cur][1] = 1; // cur이 얼리 어답터일때

        for (Integer next : edges[cur]) {
            if (!visited[next]) {
                dfs(next);
                dp[cur][0] += dp[next][1];
                dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }

    }
}
