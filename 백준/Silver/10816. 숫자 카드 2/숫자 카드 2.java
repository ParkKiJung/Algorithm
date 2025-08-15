import java.util.*;
import java.io.*;

public class Main {

    static int[] arr, counts;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        counts = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            sb.append(findUpper(counts[i]) - findLower(counts[i])).append(" ");
        }

        System.out.println(sb.toString());
    }

    static int findUpper(int n) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > n) right = mid;
            else left = mid + 1;
        }

        return left;
    }
    static int findLower(int n) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= n) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
