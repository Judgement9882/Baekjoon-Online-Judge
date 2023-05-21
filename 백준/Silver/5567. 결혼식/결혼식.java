import java.io.*;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception{
		// https://www.acmicpc.net/problem/5567
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[n+1];
		for(int i =1 ; i <= n; i++) list[i] = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		boolean[] v = new boolean[n+1];
		v[1] = true; // 상근이
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int ans = 0;
		for(int num : list[1]) { // 상근이 친구 초대
			q.offer(num);
			v[num] = true;
			ans++;
		}
		
		// 친구의 친구 초대
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int k : list[num]) {
				if(!v[k]) {
					ans++;
					v[k] = true;
				}
			}
		}
		System.out.println(ans);
		

		br.close();
	}
}