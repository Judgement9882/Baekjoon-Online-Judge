import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    // 두개로 나눠서 Log N의 시간복잡도로 접근
    static BigInteger factorial(int a, int N) {
        if(a<N){
            // 작을 경우 나눠서 접근
            int b = (a+N)/2;
            return factorial(a, b).multiply(factorial(b+1, N));
        }else{
            // a==N 그대로 a 반환
            return BigInteger.valueOf(a);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(factorial(1, N));
    }
}