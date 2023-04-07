import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if(N/2 < M) M = N-M; // 반토막
		
		BigInteger son = BigInteger.ONE;
        BigInteger mom = BigInteger.ONE;

        // 6C3 의 경우 6*5*4 / 1*2*3
        for (int i = 0; i < M; i++) {
            son = son.multiply(new BigInteger(String.valueOf(N - i)));
            mom = mom.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        BigInteger answer = son.divide(mom);

        System.out.println(answer);
		
		br.close();
	}
}