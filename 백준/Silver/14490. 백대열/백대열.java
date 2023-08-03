import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long gcd = cal_gcd(A,B);
        StringBuilder sb = new StringBuilder();
        sb.append(A/gcd).append(":").append(B/gcd);
        System.out.println(sb);
        br.close();
    }

    static long cal_gcd(long a, long b) {
        long c;
        while(b!=0) {
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }
}