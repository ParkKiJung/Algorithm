import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            list.add(heights[i + 1] - heights[i]);
        }

        int answer = 0;
        Collections.sort(list);

        for (int i = 0; i < N - K; i++) {
            answer += list.get(i);
        }

        System.out.println(answer);

    }
}
