import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) stack.push(c);
            else {
                if (c == ')') {
                    if (stack.peek() == '(') stack.pop();
                    else stack.push(c);
                } else stack.push(c);
            }
        }

        answer = stack.isEmpty();
        
        return answer;
    }
}