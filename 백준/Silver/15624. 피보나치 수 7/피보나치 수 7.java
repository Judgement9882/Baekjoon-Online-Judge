import java.io.*;
import java.util.*;
public class Main {
    static long mod = 1_000_000_007;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if(n==0) System.out.print("0");
        else {
            long[][] Matrix = {{1, 1}, {1, 0}};
            Matrix = func(Matrix, n);
            System.out.println(Matrix[0][1]); // Fn+1, Fn 이므로
        }
        br.close();
    }

    static long[][] func(long[][] M, long k) {
        if(k==1) return M;
        long[][] temp = func(M, k/2);
        temp = calcMul(temp, temp);

        // 짝수 홀수 나눠서
        if(k%2 == 0) return temp;
        else {
            long[][] unitM = {{1,1},{1,0}};
            return calcMul(temp, unitM);
        }
    }

    static long[][] calcMul(long[][] M1, long[][] M2) {
        long [][] ret = new long[2][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0 ; j < 2; j++) {
                for(int k = 0 ; k < 2; k++) {
                    ret[i][j] += M1[i][k] * M2[k][j];
                    ret[i][j] %= mod;
                }
            }
        }
        return ret;
    }
}