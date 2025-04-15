import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int maxH = Integer.parseInt(video_len.substring(0, 2));
        int maxM = Integer.parseInt(video_len.substring(3, 5));
        int maxT = 60 * maxH + maxM;
        
        int curH = Integer.parseInt(pos.substring(0, 2));
        int curM = Integer.parseInt(pos.substring(3, 5));
        int curT = 60 * curH + curM;
        
        int stH = Integer.parseInt(op_start.substring(0, 2));
        int stM = Integer.parseInt(op_start.substring(3, 5));
        int stT = 60 * stH + stM;
        
        int endH = Integer.parseInt(op_end.substring(0, 2));
        int endM = Integer.parseInt(op_end.substring(3, 5));
        int endT = 60 * endH + endM;
        
        if (curT >= stT && curT <= endT) curT = endT;
        
        for (String cmd : commands) {
            
            // 오프닝 구간인지 확인하고 구간 내라면 오프닝 끝나는 위치로 이동
            if (cmd.equals("next")) {
                curT += 10;
            } else {
                curT -= 10;
            }
            
            if (curT > maxT) curT = maxT;
            else if (curT < 0) curT = 0;
            if (curT >= stT && curT <= endT) curT = endT;
            
        }
        
        // 마지막 답 출력시에만 분 초 형태로 출력하기
    
        int h = curT / 60;
        int m = curT % 60;
        
        if (h < 10) answer += "0";
        answer += h + ":";
        
        if (m < 10) answer += "0";
        answer += m;
    
        return answer;
    }
}