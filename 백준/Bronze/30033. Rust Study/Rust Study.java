import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] A = new int[N];
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (A[i] <= num) ans++;
        }
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}