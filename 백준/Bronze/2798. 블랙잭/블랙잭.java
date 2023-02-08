import java.io.*;
import java.util.*;

public class Main{
	
	static int N, M, sum=0;
	static int [] a, num;
	
	static void comb(int cnt, int start) {
		
		if(cnt == 3) {
			int temp = 0;
			for(int i = 0; i < cnt; i++) {
				temp += a[i];
			}
			if(M < temp) return;
			if(sum <= temp) {
				sum = temp;
			}
			return;
		}
		for(int i = start; i < N; i++) {
			a[cnt] = num[i];
			comb(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[3];
		num = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		comb(0, 0);
		System.out.println(sum);
	}
}
