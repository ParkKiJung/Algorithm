import java.util.*;

class Solution {
    
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        
        int row = maps.length;
        int col = maps[0].length();
        
        Character[][] map = new Character[row][col];
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] || map[i][j] == 'X') continue;
                int sum = 0;
                visited[i][j] = true;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                
                while (!queue.isEmpty()) {
                    int[] info = queue.poll();
                    int cR = info[0];
                    int cC = info[1];
                    sum += map[cR][cC] - '0';
                    for (int[] d : dir) {
                        int nR = cR + d[0];
                        int nC = cC + d[1];
                        if (nR >= row || nR < 0 || nC >= col || nC < 0) continue;
                        if (visited[nR][nC] || map[nR][nC] == 'X') continue;
                        visited[nR][nC] = true;
                        queue.add(new int[]{nR, nC});
                    }
                    
                }
                
                list.add(sum);
                
            }
            
        }
        
        Collections.sort(list);
        if (list.isEmpty()) return new int[]{-1};
            
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}