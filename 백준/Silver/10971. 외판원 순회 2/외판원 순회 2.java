import java.io.*;
import java.util.*;
public class Main {
	static int N, ans;
	static int[][] W;
	static boolean[] v;
	
	static void func(int cnt, int pay, int start, int prev) {
		if(pay > ans) return;
		
		if(cnt == N) {
			if(W[prev][start] != 0) { // 연결되어있지 않으면 가지않음
				ans = Math.min(ans, pay+W[prev][start]);
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(v[i]) continue;
			if(W[prev][i] == 0) { // 연결되어있지 않으면 가지않음
				continue;
			}
			v[i] = true;
			func(cnt+1, pay+W[prev][i], start, i);
			v[i] = false;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		v = new boolean[N];
		ans=Integer.MAX_VALUE/2;
		for(int i = 0; i < N; i++) {
			v[i] = true;
			func(1, 0, i, i);
			v[i] = false;
		}
		System.out.println(ans);
		br.close();
	}
}