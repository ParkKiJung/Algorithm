import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int left = 0, right = 0;
        int sum = sequence[0];

        int minLen = Integer.MAX_VALUE;
        int start = 0, end = 0;

        while (right < n) {
            if (sum == k) {
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    start = left;
                    end = right;
                }
                sum -= sequence[left++];
            } else if (sum < k) {
                right++;
                if (right < n) sum += sequence[right];
            } else {
                sum -= sequence[left++];
            }
        }

        return new int[]{start, end};
    }
}