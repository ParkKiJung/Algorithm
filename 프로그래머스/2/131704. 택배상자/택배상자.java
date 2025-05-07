import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        int answer = 0;
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 1; i <= order.length; i++) {
            stack.push(i);
            while(!stack.isEmpty()) {
                if (stack.peek() == order[idx]) {
                    stack.pop();
                    idx++;
                } else break;
            }
        }
        
        return idx;
    }
}