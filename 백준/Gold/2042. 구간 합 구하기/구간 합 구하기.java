import java.io.*;
import java.util.*;
public class Main {
	static long[] tree, arr;
	static int N, M, K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		tree = new long[N+1];
		arr = new long[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
			update(i, arr[i]);
		}
		
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a==1) { // update
				long c = Long.parseLong(st.nextToken());
				long diff = c - arr[b];
				arr[b] = c;
				update(b, diff);
			}else if (a==2) { // sum 
				int c = Integer.parseInt(st.nextToken());
				sb.append(sum(c) - sum(b-1) + "\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
	
	static void update(int i, long diff) {
		while(i <= N) {
			tree[i] += diff;
			i += (i & -i);
		}
	}
	
	static long sum(int i) {
		long ans = 0;
		while(i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}
}