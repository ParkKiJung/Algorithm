import java.util.*;

class Solution {
    public int solution(int n) {
    int answer = 0;

    for (int k = 1; k * (k + 1) / 2 <= n; k++) {
        int x = n - k * (k - 1) / 2; // 수식으로 접근하기
        // x가 시작인 연속하는 k개의 자연수의 합
        if (x % k == 0) {
            answer++;
        }
    }

    return answer;
}
}