import java.util.*;

class Solution {
    static List<Integer>[] edges;
    public int solution(int n, int[][] edge) {
        
        edges = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();    
        }
        
        for (int[] e : edge) {
            int from = e[0];
            int to = e[1];
            edges[from].add(to);
            edges[to].add(from);
        }
        
        
        return bfs(n);
    }
    
    static int bfs(int n) {
        int max = 0;
        int cnt = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1}); // 처음이 시작지점. 두번째가 깊이
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int cur = info[0];
            int depth = info[1];
            
            if (depth == max) {
                cnt++;
            } else if (depth > max) {
                max = depth;
                cnt = 1;
            }
            
            for (int next : edges[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(new int[]{next, depth + 1});
            }
            
        }
        
        return cnt;
        
    }
}