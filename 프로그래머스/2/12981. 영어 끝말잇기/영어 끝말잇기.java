import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char start = words[0].charAt(0);
        int turn = -1;
        int num = -1;
        // n명
        for (int i = 0; i < words.length; i++) {
            if (set.contains(words[i]) || start != words[i].charAt(0)) {
                num = (i % n) + 1;
                turn = (i / n) + 1;
                break;
            } else {
                set.add(words[i]);
                start = words[i].charAt(words[i].length() - 1);
            }
        }
        
        int[] answer = new int[2];
        
        if (turn == -1) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = num;
            answer[1] = turn;
        }

        return answer;
    }
}