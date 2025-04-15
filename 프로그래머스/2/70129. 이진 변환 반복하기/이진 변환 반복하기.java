import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int turn = 0;
        // 이진 변환의 횟수
        // 제거된 0의 개수 리턴하기
        
        while(!s.equals("1")) {
            // 0지우기
            turn++;
            String str = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '1') str += c;
                else zeroCnt++;
            }
            
            int len = str.length();
            s = Integer.toBinaryString(len);
            
        }
        
        answer[0] = turn;
        answer[1] = zeroCnt;
        
        return answer;
        
        
    }
}