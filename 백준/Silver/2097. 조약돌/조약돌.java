import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(br.readLine());
        Double N = Double.parseDouble(br.readLine());
        if(N==1 || N == 2) System.out.print("4");
        else {
            int prevNum = 0;
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                if (i * i >= N) {
                    prevNum = (i - 1) * (i - 1);
                    break;
                }
            }
            int plus = (int) Math.sqrt(prevNum);
            double ans = 0.0;
            if (N <= prevNum + plus) {
                // 작거나 같을경우
                ans = (plus + plus - 1) * 2;
            } else {
                ans = (plus + plus) * 2;
            }
            System.out.print((int) ans);
//        System.out.println(sb);
        }
        br.close();
    }
}

/*
*   1, 2, 3, 4 -> 1x1 = 4
*   5, 6 -> 2x1 = 6
*   7, 8, 9 -> 2x2 = 8
*   10 11 12 -> 3x2 = 10
*   13 14 15 16 -> 3x3 = 12
*   17 18 19 20 -> 4x3 = 14
*   21 22 23 24 25 -> 4x4 = 16
*
* */