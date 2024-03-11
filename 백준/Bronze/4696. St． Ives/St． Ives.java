import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            double M = Double.parseDouble(br.readLine());
            if(M==0.0) break;
            double ans = 1 + P(M, 1) + P(M, 2) + P(M, 3) + P(M, 4);
            sb.append(String.format("%.2f", ans)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
    static double P(double M, int n) {
        return Math.pow(M, n);
    }
}