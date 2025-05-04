import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        // dp 같은데?
        int[][] dp = new int[N][4];

        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for (int i = 0; i < N - 1; i++) {
            
            for (int j = 0; j < 4; j++) {
                // 해당 열 제외고 찾기
                int max = 0;
                int idx = -1;
                for (int k = 0; k < 4; k++) {
                    if (k == j) continue;
                    dp[i + 1][k] = Math.max(dp[i + 1][k], dp[i][j] + land[i + 1][k]);
                }
            }
            
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            if (dp[N - 1][i] > max) max = dp[N - 1][i];
        }
        
        return max;
    }
}