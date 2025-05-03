class Solution {

    static int[] dx = {0, 0, 1, -1}; // U, D, R, L
    static int[] dy = {1, -1, 0, 0};

    public int solution(String dirs) {
        boolean[][][][] visited = new boolean[11][11][11][11];

        int x = 5, y = 5;
        int cnt = 0;

        for (char c : dirs.toCharArray()) {
            int dir = -1;
            if (c == 'U') dir = 0;
            else if (c == 'D') dir = 1;
            else if (c == 'R') dir = 2;
            else if (c == 'L') dir = 3;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 경계 확인
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;

            // 아직 안 지나간 길이라면
            if (!visited[x][y][nx][ny] && !visited[nx][ny][x][y]) {
                visited[x][y][nx][ny] = true;
                visited[nx][ny][x][y] = true;
                cnt++;
            }

            // 위치 이동
            x = nx;
            y = ny;
        }

        return cnt;
    }
}