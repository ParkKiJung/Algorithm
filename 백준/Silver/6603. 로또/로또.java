import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] nums;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            if (size == 0) break;

            nums = new int[size];

            for (int i = 0; i < size; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums);
            list = new ArrayList<>();
            comb(-1, 0);
            System.out.println();

        }



    }

    // 6개 골라야 함
    static void comb(int pos, int selected) {
        if (selected == 6) {
            for (Integer num : list) System.out.print(num + " ");
            System.out.println();
            return;
        }

        for (int i = pos + 1; i < nums.length; i++) {
            list.add(nums[i]);
//            System.out.println("added " + nums[i]);
            comb(i, selected + 1);
            list.remove(list.size() - 1);
        }

    }
}
