import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static long[] heights;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        heights = new long[N];

        long left = 0;
        long right = 0;
        for (int i = 0; i < N; i++) {
            heights[i] = Long.parseLong(br.readLine());
            right = Math.max(right, heights[i]);
        }
        right++;

        while (left < right) {
            long mid = (left + right) / 2;
            if (getCount(mid) < K) right = mid;
            else left = mid + 1;
        }

        System.out.println(left -  1);
    }

    static int getCount(long height) {
        int cnt = 0;
        for (long h : heights) {
            cnt += h / height;
        }
        return cnt;
    }
}
