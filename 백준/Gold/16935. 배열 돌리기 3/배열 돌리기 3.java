import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int row, col;
    static int[][] arr, tempArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int commandNum = Integer.parseInt(st.nextToken());
        arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < commandNum; i++) {
            method(Integer.parseInt(st.nextToken()));
        }

        print();

    }

    static void method(int idx) {
        switch (idx) {
            case 1:
                method1();
                break;
            case 2:
                method2();
                break;
            case 3:
                method3();
                break;
            case 4:
                method4();
                break;
            case 5:
                method5();
                break;
            case 6:
                method6();
                break;
        }
    }
    // 상하 반전
    static void method1() {
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                swap(i, j, row - 1 - i, j);
            }
        }
    }

    // 좌우 반전
    static void method2() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                swap(i, j, i, col - 1 - j);
            }
        }
    }

    // 오른쪽 90도
    static void method3() {
        tempArr = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tempArr[j][row - 1 - i] = arr[i][j];
            }
        }

        row = tempArr.length;
        col = tempArr[0].length;
        arr = tempArr;
    }

    // 왼쪽 90도
    static void method4() {
        tempArr = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tempArr[col - 1 - j][i] = arr[i][j];
            }
        }

        row = tempArr.length;
        col = tempArr[0].length;
        arr = tempArr;
    }

    // 분할 후 오른쪽
    static void method5() {

        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col / 2; j++) {
                swap(i, j, i, j + col / 2);
            }
        }

        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col / 2; j++) {
                swap(i, j, i + row / 2, j);
            }
        }

        for (int i = row / 2; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                swap(i, j, i, j + col / 2);
            }
        }
    }

    // 분할 후 왼쪽
    static void method6() {

        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col / 2; j++) {
                swap(i, j, i, j + col / 2);
            }
        }

        for (int i = 0; i < row / 2; i++) {
            for (int j = col / 2; j < col; j++) {
                swap(i, j, i + row / 2, j);
            }
        }

        for (int i = row / 2; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                swap(i, j, i, j + col / 2);
            }
        }


    }

    static void swap(int row1, int col1, int row2, int col2) {
        int temp = arr[row1][col1];
        arr[row1][col1] = arr[row2][col2];
        arr[row2][col2] = temp;
    }

    static void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}

