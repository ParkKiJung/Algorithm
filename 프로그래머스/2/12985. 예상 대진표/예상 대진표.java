import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        int A = Math.min(a, b);
        int B = Math.max(a, b);
        while (true) {
            if (A + 1 == B && (A % 2) == 1 && (B % 2) == 0) break;
            answer++;
            A = (A / 2) + (A % 2);
            B = (B / 2) + (B % 2);
        }
        
    
        return answer;
    }
}