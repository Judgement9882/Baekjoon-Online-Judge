import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while(N > 0) {
			
			boolean isPrime = true;
			for(int i=2 ; i * i <= N; i++) {
				if(N % i == 0) {
					isPrime = false;
					break;
				}
			}
			if(!isPrime) break;
			
			N++;
		}
		System.out.println(N);
	}
}
