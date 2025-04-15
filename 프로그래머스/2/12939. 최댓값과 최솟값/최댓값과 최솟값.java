import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String str : sArr) {
            int value = Integer.parseInt(str);
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        
        
        String answer = "";
        answer += min + " " + max;
        return answer;
    }
}