import java.util.*;

class Solution {
    
    static boolean[] selected;
    static int[] numbers;
    static int answer = 0;
    public int solution(int[] number) {
        selected = new boolean[number.length];
        numbers = number;
        dfs(-1, 0, 0);
        
        return answer;
    }
    
    static void dfs(int cur, int selectedCnt, int sum) {
        if (selectedCnt == 3) {
            if (sum == 0) answer++;
            return;
        }
        
        for (int i = cur + 1; i < numbers.length; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            dfs(i, selectedCnt + 1, sum + numbers[i]);
            selected[i] = false;
        }
    }
}