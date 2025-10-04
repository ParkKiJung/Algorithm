import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split("[+-]");
        String[] signArr = str.split("[0-9]+");
        Queue<Integer> queue = new LinkedList<>();

        int sum = Integer.parseInt(arr[0]);
        for (int i = 1; i < signArr.length; i++) {
            String sign = signArr[i];

            if (sign.equals("-")) {
                queue.add(sum);
                sum = Integer.parseInt(arr[i]);
            } else {
                sum += Integer.parseInt(arr[i]);
            }
        }
        queue.add(sum);

        int answer = queue.poll();
        for (Integer num : queue) answer -= num;

        System.out.println(answer);
    }
}
