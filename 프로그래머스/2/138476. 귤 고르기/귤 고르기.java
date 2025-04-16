import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
            set.add(t);
        }
        
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            int key = it.next();
            list.add(map.get(key));
        }
        
        int sum = 0;
        Collections.sort(list, Comparator.reverseOrder());
        for (int value : list) {
            sum += value;
            answer++;
            if (sum >= k) break;
        }
        
        return answer;
    }
}