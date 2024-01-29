import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int [] A = new int[N];
        st = new StringTokenizer(br.readLine());
        int D = Math.abs(S - Integer.parseInt(st.nextToken()));
        for(int i = 1; i < N; i++){
            D = gcd(D, Math.abs(S - Integer.parseInt(st.nextToken())));
        }
        System.out.print(D);
        br.close();
    }

    static int gcd(int a, int b){
        if(a<b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while(b!=0){
            int ret = a%b;
            a = b;
            b = ret;
        }
        return a;
    }
}