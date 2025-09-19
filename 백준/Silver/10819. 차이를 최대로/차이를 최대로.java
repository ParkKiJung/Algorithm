import java.util.*;
import java.io.*;

public class Main {
    static int[] nums;
    static boolean[] visited;
    static int N;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            find(i, 0, 0);
            visited[i] = false;
        }

        System.out.println(answer);
    }

    static void find(int lastPos, int len, int sum) {
        if (len == N - 1) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            find(i, len + 1, sum + Math.abs(nums[lastPos] - nums[i]));
            visited[i] = false;
        }
    }
}
