import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] t = new long[N+1];
        t[0] = 1;
        for(int i = 1 ; i <= N; i++){
            long temp = 0;
            for(int j = 0; j <= i-1; j++ ){
                temp += t[j]*t[i-1-j];
            }
            t[i] = temp;
        }
        System.out.print(t[N]);
        br.close();
    }
}