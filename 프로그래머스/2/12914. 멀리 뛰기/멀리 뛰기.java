import java.util.*;

class Solution {
    public long solution(int n) {
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (i + 1 <= n) dp[i + 1] = (dp[i + 1] + dp[i]) % 1234567;
            if (i + 2 <= n) dp[i + 2] = (dp[i + 2] + dp[i]) % 1234567;
        }
        
        return dp[n];

    }
}