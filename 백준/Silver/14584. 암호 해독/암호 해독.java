import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char[] password;
    static int N;
    static String[] words;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        password = br.readLine().toCharArray();

        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        String newPassword = "";
        for (int i = 0; i < 26; i++) {
            increase();
            newPassword = "";
            for (int j = 0; j < password.length; j++) {
                newPassword += password[j];
            }

            boolean find = false;
            for (int j = 0; j < words.length; j++) {
                // 각 단어가 포함되어있는지 확인하기
                if (newPassword.contains(words[j])) {
                    find = true;
                    break;
                }
            }

            if (find) break;
        }

        System.out.println(password);
    }

    static void increase() {
        for (int i = 0; i < password.length; i++) {
            if (password[i] == 'z') password[i] = 'a';
            else password[i] = (char) (password[i] + 1);
        }
    }
}
