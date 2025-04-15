import java.io.*;
import java.util.*;

class Solution {
    
    static Pos[] poses;
    static int[][] map = new int[101][101];
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우 (r 좌표 변화 우선)
    static Queue<Robot> robots = new LinkedList<>();
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        poses = new Pos[points.length + 1];
        for (int i = 0; i < points.length; i++) {
            poses[i + 1] = new Pos(points[i][0], points[i][1]);
        }
        
        for (int i = 0; i < routes.length; i++) {
            Pos cur = poses[routes[i][0]];
            robots.add(new Robot(cur.r, cur.c, i, 1)); // sIdx는 1부터 시작 (다음 목적지 인덱스)
            map[cur.r][cur.c]++;
        }
        
        answer += crashNum();
        
        while (!robots.isEmpty()) {
            int size = robots.size();
            
            for (int i = 0; i < size; i++) {
                Robot robot = robots.poll();
                map[robot.r][robot.c]--;
                
                // 모든 목적지를 방문했으면 더 이상 이동하지 않음
                if (robot.sIdx >= routes[robot.idx].length) continue;
                
                Pos target = poses[routes[robot.idx][robot.sIdx]];
                int curDist = getDist(robot.r, robot.c, target.r, target.c);
                
                // 방향 우선순위대로 이동 시도 (r 좌표 변화 우선)
                for (int[] d : dir) {
                    int nR = robot.r + d[0];
                    int nC = robot.c + d[1];
                    
                    // 맵 범위 체크
                    if (nR <= 0 || nR > 100 || nC <= 0 || nC > 100) continue;
                    
                    // 최단 거리 체크 (현재보다 가까워져야 함)
                    int newDist = getDist(nR, nC, target.r, target.c);
                    if (newDist >= curDist) continue;
                    
                    // 로봇 이동 처리
                    int nextSIdx = robot.sIdx;
                    
                    // 목적지에 도착했는지 체크
                    if (nR == target.r && nC == target.c) {
                        nextSIdx++; // 다음 목적지로 인덱스 증가
                    }
                    
                    // 로봇 위치 업데이트
                    map[nR][nC]++;
                    robots.add(new Robot(nR, nC, robot.idx, nextSIdx));
                    break; // 한 방향으로만 이동
                }
                
            }
            
            answer += crashNum();
        }
        
        return answer;
    }
    
    // 맨해튼 거리 계산
    static int getDist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
    
    // 충돌 위험 상황 개수 계산
    static int crashNum() {
        int cnt = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (map[i][j] >= 2) cnt++;
            }
        }
        
        return cnt;
    }
}

class Robot {
    int r;
    int c;
    int idx;
    int sIdx;
    
    Robot(int r, int c, int idx, int sIdx) {
        this.r = r;
        this.c = c;
        this.idx = idx;
        this.sIdx = sIdx;
    }
}

class Pos {
    int r;
    int c;
    Pos (int r, int c) {
        this.r = r;
        this.c = c;
    }
}