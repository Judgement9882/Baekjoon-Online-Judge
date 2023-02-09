import java.io.*;
import java.util.*;

public class Main{
	
	static int N, ans = Integer.MAX_VALUE;
	static Taste[] T;
	static boolean[] isused;
	static class Taste{
		int s;
		int b;
		
		Taste(int s, int b){
			this.s = s;
			this.b = b;
		}
	}
	
	static void subsets(int cnt) {
		if(cnt == N) {
			int s_mul = 1;
			int b_sum = 0;
			for(int i = 0; i < N; i++) {
				if(isused[i]) {
					s_mul *= T[i].s;
					b_sum += T[i].b;
				}
			}
			
			// 공집합 제외
			if(s_mul == 1 && b_sum == 0) return;
			ans = Math.min(ans, Math.abs(s_mul - b_sum));
			
			return;
		}
		
		isused[cnt] = true;
		subsets(cnt+1);
		isused[cnt] = false;
		subsets(cnt+1);
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		T = new Taste[N];
		isused = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int temp_s= Integer.parseInt(st.nextToken());
			int temp_b= Integer.parseInt(st.nextToken());
			T[i] = new Taste(temp_s, temp_b);
		}
		
		subsets(0);
		System.out.println(ans);
		br.close();
	}
}
