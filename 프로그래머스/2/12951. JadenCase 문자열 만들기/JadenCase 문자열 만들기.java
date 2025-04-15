import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isFirst = true;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer += c;
                isFirst = true;
                continue;
            } else {
                if (isFirst) {
                    answer += Character.toUpperCase(c);
                    isFirst = false;
                } else answer += Character.toLowerCase(c);
            }
            
        }
        
        
        return answer;
    }
}