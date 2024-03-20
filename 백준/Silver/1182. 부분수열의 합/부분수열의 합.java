import java.io.*;
import java.util.*;
public class Main {

    static int N, M, C;
    static int[] arr, selected;
    static StringBuilder sb = new StringBuilder();

    static void subset(int cnt, int sum){
        if(cnt == N){
            if(sum == M) C++;
            return;
        }
        subset(cnt+1, sum+arr[cnt]);
        subset(cnt+1, sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        C = 0;
        subset(0, 0);
        sb.append(M==0?C-1:C); // M이 0이면 크기가 0인 부분집합 존재 가능.
        System.out.println(sb);
        br.close();
    }
}