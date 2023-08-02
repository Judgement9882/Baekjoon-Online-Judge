import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long C = Long.parseLong(st.nextToken());
        long D = Long.parseLong(st.nextToken());

        long mom = B*D;
        long son = A*D + B*C;
        long gcd = cal_gcd(mom, son);
        StringBuilder sb = new StringBuilder();
        sb.append(son/gcd).append(" ").append(mom/gcd);
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