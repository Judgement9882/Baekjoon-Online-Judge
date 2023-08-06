import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());
        double ans = 0.0;
        int num = 0;
        for(int i = 0 ; i < N; i++){
            if(cal_gcd(A[i],X) == 1){ // 서로소이면
                num++;
                ans += A[i];
            }
        }
        System.out.println(ans/num);
        br.close();
    }

    static int cal_gcd(int a, int b) {
        int c;
        while(b!=0) {
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }
}