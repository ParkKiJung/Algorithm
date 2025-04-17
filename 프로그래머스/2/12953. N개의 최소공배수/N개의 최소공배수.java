import java.util.*;

class Solution {
    public int solution(int[] arr) {
        
        int g = gcd(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / g;
        
        for (int i = 2; i < arr.length; i++) {
            g = gcd(lcm, arr[i]);
            lcm = (lcm * arr[i]) / g;
            
        }
        
        return lcm;
    }
    
    // 최대 공약수 구하기
    static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}