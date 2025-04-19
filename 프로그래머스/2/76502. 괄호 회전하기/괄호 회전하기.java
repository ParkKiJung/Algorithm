import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            // 스택 돌면서 확인하기
            for (int j = 0; j < sb.length(); j++) {
                char c = sb.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (c == ']') {
                        if (stack.peek() == '[') stack.pop();
                        else stack.push(c);
                    } else if (c == ')') {
                        if (stack.peek() == '(') stack.pop();
                        else stack.push(c);
                    } else if (c == '}') {
                        if (stack.peek() == '{') stack.pop();
                        else stack.push(c);
                    } else stack.push(c);
                }
            }
            
            if (stack.isEmpty()) answer++;
            
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            
        }
        
        
        return answer;
    }
}