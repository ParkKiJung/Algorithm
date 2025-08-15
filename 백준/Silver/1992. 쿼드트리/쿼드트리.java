import java.io.*;

public class Main {
    static int[][] location;
    static String output = "";
    static void findArea(int startRow, int startCol, int size) {

        int curArea = location[startRow][startCol];
        for (int i = startRow; i < startRow + size; i++) {
            for (int j = startCol; j < startCol + size; j++) {
                if (location[i][j] != curArea) {
                    int newSize = size / 2;
                    output += "(";
                    findArea(startRow, startCol, newSize);
                    findArea(startRow, startCol + newSize, newSize);
                    findArea(startRow + newSize, startCol, newSize);
                    findArea(startRow + newSize, startCol + newSize, newSize);
                    output += ")";
                    return;
                }
            }
        }

        output += Integer.toString(curArea);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        location = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < size; j++) {
                location[i][j] = Integer.parseInt(input[j]);
            }
        }

        findArea(0, 0, size);
        System.out.println(output);

    }
}
