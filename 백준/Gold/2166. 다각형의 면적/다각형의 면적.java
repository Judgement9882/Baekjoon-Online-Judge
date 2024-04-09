import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] x = new long[N];
        long [] y = new long[N];
        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        // 신발끈의 공식을 이용한 다각형 넓이 구하기
        long a = x[N-1]*y[0], b = y[N-1]*x[0];
        for(int i = 0; i < N-1; i++){
            a += x[i]*y[i+1];
            b += y[i]*x[i+1];
        }
        System.out.printf("%.1f", Math.abs(a-b)*0.5);
        br.close();
    }
}