import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int[] arr = new int[elements.length * 2];
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = elements[i % elements.length];
        }
        
        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = 0; j < elements.length; j++) {
                sum += arr[i + j];
                set.add(sum);
            }
        }
        
        return set.size();
        
        
    }
}