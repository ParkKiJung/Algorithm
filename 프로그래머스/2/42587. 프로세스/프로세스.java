import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int[] answer = new int[priorities.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            int pr = priorities[i];
            pq.add(pr);
            queue.add(new Process(i, pr));
        }
        
        int order = 1;
        while (!pq.isEmpty()) {
            int pr = pq.poll();
            while (true) {
                Process cur = queue.poll();
                if (cur.pr == pr) {
                    answer[cur.idx] = order++;
                    break;
                } else queue.add(cur);
            }
        }
        
        
        return answer[location];
    }
}

class Process {
    int idx;
    int pr;
    Process(int idx, int pr) {
        this.idx = idx;
        this.pr = pr;
    }
}