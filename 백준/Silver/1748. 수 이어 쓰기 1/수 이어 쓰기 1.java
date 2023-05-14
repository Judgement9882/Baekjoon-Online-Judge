import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		// 1의자리수 : N개
		// 10의 자리수 : N-9개
		// 100의 자리수 : N-99개 ...
		for(int i = 1; i <= N; i*=10) ans += N-i+1;
		System.out.println(ans);
		br.close();
	}
}