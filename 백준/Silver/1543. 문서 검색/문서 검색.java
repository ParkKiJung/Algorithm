import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st1 = br.readLine();
        String st2 = br.readLine();

        int answer = 0;

        for (int i = 0; i <= st1.length() - st2.length(); ) {
            if (st1.charAt(i) != st2.charAt(0)) {
                i++;
                continue;
            }

            int cnt = 0;
            int startIdx = i;
            for (int j = 0; j < st2.length(); j++) {
                if (st1.charAt(i) == st2.charAt(j)) {
                    cnt++;
                    i++;
                } else break;
            }

            if (cnt == st2.length()) answer++;
            else i = startIdx + 1;

        }

        System.out.println(answer);

    }
}
