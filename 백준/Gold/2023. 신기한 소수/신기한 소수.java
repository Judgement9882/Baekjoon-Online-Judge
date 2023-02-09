import java.io.*;
import java.util.*;

public class Main{
	
	static int N;
	static StringBuilder sb = new StringBuilder();
	static int [] possibleNum = {1, 3, 7, 9};
	// 소수인지 아닌지 판별하는 함수
	static boolean isPrime(int num) {
		if(num == 1) return false;
		for(int i = 2; i * i <= num; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
	
	// 자릿수를 늘려가며 탐색
	static void func(int num, int cnt) {
		if(cnt == N) {
			sb.append(num).append("\n");
		}
		
		// 만족하지 않을경우 num에 10을 곱하고 1,3, 7, 9을 더함
		for(int n : possibleNum) {
			int temp = 10*num + n;
			if(isPrime(temp)) func(temp, cnt+1);
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 첫자리는 2, 3, 5, 7만 들어갈 수 있음
		func(2,1);
		func(3,1);
		func(5,1);
		func(7,1);
		
		System.out.println(sb);
		br.close();
	}
}
