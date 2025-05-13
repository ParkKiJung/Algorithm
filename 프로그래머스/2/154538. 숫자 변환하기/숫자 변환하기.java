import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[1_000_001];

        queue.offer(new int[]{x, 0}); 
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int now = current[0];
            int count = current[1];

            if (now == y) return count;

            // 다음 가능한 연산들
            int[] nexts = {now + n, now * 2, now * 3};
            for (int next : nexts) {
                if (next <= y && !visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, count + 1});
                }
            }
        }

        return -1; // y에 도달할 수 없는 경우
    }
}