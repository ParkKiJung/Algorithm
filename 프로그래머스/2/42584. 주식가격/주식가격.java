import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i ++) {
            // 가격이 떨어졌다면
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int top = stack.pop();
                answer[top] = i - top;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int top = stack.pop();
            answer[top] = n - 1 - top;
        }
        
        return answer;
    }
}