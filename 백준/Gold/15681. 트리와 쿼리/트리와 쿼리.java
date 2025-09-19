import java.util.*;
import java.io.*;

public class Main {

    static int N, R, Q;
    static List<Integer>[] edges;
    static int[] subSize;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        subSize = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        visited = new boolean[N + 1];
        dfs(R);

        for (int i = 0; i < Q; i++) {
            int cur = Integer.parseInt(br.readLine());
            sb.append(subSize[cur]).append("\n");
        }

        System.out.print(sb);
    }

    static int dfs(int cur) {
        visited[cur] = true;
        subSize[cur] = 1;

        for (Integer next : edges[cur]) {
            if (!visited[next]) {
                subSize[cur] += dfs(next);
            }
        }

        return subSize[cur];
    }
}
