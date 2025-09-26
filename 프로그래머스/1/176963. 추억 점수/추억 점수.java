import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> scoreMap = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            String str = name[i];
            int score = yearning[i];
            scoreMap.put(str, score);
        }
        
        for (int i = 0; i < photo.length; i++) {
            String[] photos = photo[i];
            int score = 0;
            for (String p : photos) {
                if (!scoreMap.containsKey(p)) continue;
                score += scoreMap.get(p);
            }
            answer[i] = score;
        }
        
        return answer;
    }
}