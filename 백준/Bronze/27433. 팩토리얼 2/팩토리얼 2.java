import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		
		BigInteger num = new BigInteger("1");
		
		
		for(int i = 2; i <= N; i++) {
			BigInteger num2 = new BigInteger(Integer.toString(i));
			num = num.multiply(num2);
		}
		System.out.println(num);
		
	}
}
