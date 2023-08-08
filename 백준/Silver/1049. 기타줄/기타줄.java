import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;
        int div = N / 6;
        int mod = N % 6;
        int X = Integer.MAX_VALUE, Y = Integer.MAX_VALUE;
        for(int i= 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            X = Math.min(X, Integer.parseInt(st.nextToken()));
            Y = Math.min(Y, Integer.parseInt(st.nextToken()));
        }

        if(mod==0){
            // 6의배수
            System.out.println(Math.min(X*div, Y*N));
        }else{
            if(N>6)
            // 6의 배수가 아니면
            System.out.println(Math.min((Math.min(X*(div+1) , X*div+Y*(N-6))), Y*N));
            else{
                System.out.println(Math.min(X, Y*N));
            }
        }

        br.close();
    }
}