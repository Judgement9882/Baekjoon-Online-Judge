import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int diffi[] = new int[N];
        for(int i = 0; i < N; i++) diffi[i] = Integer.parseInt(br.readLine());
        Arrays.sort(diffi);
        // 절사 평균 구하기
        int num = (int) Math.round( ((double) N) *0.15);
        double ans = 0.0;
        for(int i = num; i < N-num; i++) ans += diffi[i];
        sb.append((int) Math.round(ans/(N-num*2)));
        System.out.println(sb);
        br.close();
    }
}