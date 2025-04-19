import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> w = new HashMap<>();
        Map<String, Integer> d = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            w.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 9; i++) {
            d.put(discount[i], d.getOrDefault(discount[i], 0) + 1);
        }
        
        for (int i = 9; i < discount.length; i++) {
            d.put(discount[i], d.getOrDefault(discount[i], 0) + 1);
            if (i != 9) d.put(discount[i - 10], d.get(discount[i - 10]) - 1);
            
            boolean can = true;
            for (String key : w.keySet()) {
                if (d.get(key) != w.get(key)) {
                    can = false;
                    break;
                }
            }
            
            if (can) answer++;
            
        }
        
        return answer;
    }
}