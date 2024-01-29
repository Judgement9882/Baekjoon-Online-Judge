import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long rep = gcd(A, B);
        for(long i = 0; i < rep; i++){
            sb.append(1);
        }
        System.out.print(sb);
        br.close();
    }

    static long gcd(long a, long b){
        // a<b
        if(a<b) {
            long temp = a;
            a = b;
            b = temp;
        }

        while(b!=0){
            long ret = a%b;
            a = b;
            b = ret;
        }
        return a;
    }
}