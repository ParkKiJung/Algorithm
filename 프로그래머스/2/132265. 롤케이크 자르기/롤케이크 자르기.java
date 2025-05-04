import java.util.*;
// 경우의 수 구하기

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // 포인터 이동시키면서 갯수 확인 및 종류 확인하기...?
        int[] arr = new int[10001];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
    
        
        for (int t : topping) {
            set2.add(t);
            arr[t]++;
        }
        
        for (int t : topping) {
            if (--arr[t] == 0) set2.remove(t);
            set1.add(t);
            if(set1.size() == set2.size()) answer++;
        }
        
        
        return answer;
    }
}