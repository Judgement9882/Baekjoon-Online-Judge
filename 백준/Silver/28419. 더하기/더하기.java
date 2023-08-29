import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []A = new int[N];
        long odd = 0, even = 0;
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            if(i%2==0) odd +=A[i];
            else       even+=A[i];
        }
        /*
            N==3 홀수+2, 짝수+1만 가능
            그 이외는 두 수의 차를 출력
         */

        if(N==3){
            if(even > odd)          System.out.print(even-odd);
            else if (even == odd)   System.out.print(0);
            else                    System.out.print(-1);
        }   else                    System.out.print(Math.abs(even-odd));
        br.close();
    }
}