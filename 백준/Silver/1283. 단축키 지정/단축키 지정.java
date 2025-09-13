import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Set<Character> representSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String[] words = br.readLine().split(" ");

            boolean find = false;
            int representIdx = -1;
            int representPos = -1;
            // 규칙 1 적용
            for (int j = 0; j < words.length; j++) {
                char c = Character.toLowerCase(words[j].charAt(0));
                if (!representSet.contains(c)) {
                    representSet.add(c);
                    representIdx = j;
                    representPos = 0;
                    find = true;
                    break;
                }
            }

            // 규칙 2 적용
            if (!find) {
                for (int j = 0; j < words.length; j++) {
                    String word = words[j];
                    for (int k = 0; k < word.length(); k++) {
                        char c = Character.toLowerCase(word.charAt(k));
                        if (!representSet.contains(c)) {
                            representSet.add(c);
                            representIdx = j;
                            representPos = k;
                            find = true;
                            break;
                        }
                    }

                    if (find) break;
                }
            }

            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                for (int k = 0; k < word.length(); k++) {
                    if (j == representIdx && k == representPos) sb.append("[");
                    sb.append(word.charAt(k));
                    if(j == representIdx && k == representPos) sb.append("]");
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
