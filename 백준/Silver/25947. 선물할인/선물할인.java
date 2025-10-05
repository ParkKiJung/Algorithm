import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int giftNum, budget, saleCnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        giftNum = Integer.parseInt(st.nextToken());
        budget = Integer.parseInt(st.nextToken());
        saleCnt = Integer.parseInt(st.nextToken());

        long[] gifts = new long[giftNum + 1];


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= giftNum; i++) {
            gifts[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(gifts);

        long[] giftSum = new long[giftNum + 1];
        for (int i = 1; i <= giftNum; i++) {
            giftSum[i] = giftSum[i - 1] + gifts[i];
        }

        int answer = 0;
        for (int i = 1; i <= saleCnt; i++) {
            long needCost = giftSum[i] / 2;
            if (needCost <= budget) answer = i;
            else {
                System.out.println(answer);
                return;
            }
        }

        for (int i = saleCnt + 1; i <= giftNum; i++) {
            // i개 사는 것중 가장 비싼 saleCnt만큼 할인
            long needCost = (giftSum[i] - giftSum[i - saleCnt]) / 2;
            needCost += giftSum[i - saleCnt];
            if (needCost <= budget) answer = i;
            else break;
        }

        System.out.println(answer);
    }
}
