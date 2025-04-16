import java.util.*;

public class Solution {
    public int solution(int n) {
        
        int answer = 0;
        // 2로 계속 나누기
        while (n != 0) {
            int a = n % 2;
            n /= 2;
            answer += a;
        }
        
        return answer;
    }
}