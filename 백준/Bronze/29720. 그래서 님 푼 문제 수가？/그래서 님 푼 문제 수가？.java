import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int min = M*K;
        int max = M*K - (M-1);
        int ans1 = N-min;
        int ans2 = N-max;
        if(ans1 < 0) ans1 = 0;
        if(ans2 < 0) ans2 = 0;
        System.out.println(ans1 + " " + ans2);
        br.close();
    }
}