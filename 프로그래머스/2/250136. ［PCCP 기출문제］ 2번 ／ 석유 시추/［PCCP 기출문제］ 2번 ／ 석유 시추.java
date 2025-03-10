import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int[][] idxInfo;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static List<Integer> sums = new ArrayList<>();
    static int rowSize, colSize;
    // 좌표 탐색하면서 정보 리스트 인덱스 저장시키기
    public int solution(int[][] land) {
        
        rowSize = land.length;
        colSize = land[0].length;
        idxInfo = new int[rowSize][colSize];
        visited = new boolean[rowSize][colSize];
        int idx = 1;
        int answer = 0;
    
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    find(i, j, land, idx);
                    idx++;
                }
            }
        }
        
        
        for (int i = 0; i < colSize; i++) {
            int sum = 0;
            boolean[] used = new boolean[sums.size()];
            for (int j = 0; j < rowSize; j++) {
                if (land[j][i] == 0) continue;
                if (land[j][i] == 1 && !used[idxInfo[j][i] - 1]) {
                    sum += sums.get(idxInfo[j][i] - 1);
                    used[idxInfo[j][i] - 1] = true;
                }
            }
            
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    static void find(int row, int col, int[][] land, int idx) {
        Queue<int[]> queue = new LinkedList<>();
        visited[row][col] = true;
        idxInfo[row][col] = idx;
        queue.add(new int[]{row, col});
        int sum = 0;
        
        while(!queue.isEmpty()) {
            sum++;
            int[] info = queue.poll();
            int curRow = info[0];
            int curCol = info[1];
            
            for (int[] d : dir) {
                int nextRow = curRow + d[0];
                int nextCol = curCol + d[1];
                if (nextRow >= rowSize || nextRow < 0 || nextCol >= colSize || nextCol < 0) continue;
                if (visited[nextRow][nextCol] || land[nextRow][nextCol] == 0) continue;
                visited[nextRow][nextCol] = true;
                idxInfo[nextRow][nextCol] = idx;
                queue.add(new int[]{nextRow, nextCol});
            }
            
        }
        
        sums.add(sum);
        
        
    }
}