import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				arr[i][j] = input.charAt(j - 1) - '0';
			}
		}
		
		int max = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (arr[i][j] == 0) {
					dp[i][j] = 0;
				} else {
					int min = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
					min = Math.min(dp[i][j - 1], min);
					dp[i][j] = min + 1;
				}
				
				max = Math.max(max, dp[i][j]);
			}
		}
		
		
		System.out.println(max * max);
		
		
	}

}
