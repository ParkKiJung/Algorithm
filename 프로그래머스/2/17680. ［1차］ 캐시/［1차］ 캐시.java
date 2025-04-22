import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> map = new HashMap();
        
        if (cacheSize == 0) {
            answer += 5 * cities.length;
            return answer;
        }
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();            
            if (map.containsKey(city)) {
                answer += 1;
                map.put(city, i);
            } else {
                answer += 5;
                if (map.size() < cacheSize) {
                    map.put(city, i);
                } else {
                    int min = Integer.MAX_VALUE;
                    String minKey = "";
                    for (String key : map.keySet()) {
                        if (map.get(key) < min) {
                            min = map.get(key);
                            minKey = key;
                        }
                    }
                    map.remove(minKey);
                    map.put(city, i);
                }
            }
        }
        
        return answer;
    }
}