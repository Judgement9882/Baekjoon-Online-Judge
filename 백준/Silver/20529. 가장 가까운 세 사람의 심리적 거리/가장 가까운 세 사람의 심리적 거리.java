import java.io.*;
import java.util.*;
public class Main {
	static int T, N, ans;
	static ArrayList<String> list;
	static String[] selected;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 3명을 비교하는데, 최대한 안겹치게 나온다고 하면 16, 16 까지
			// 2명씩 나옴. 거기서 한명이라도 더 나오면 같은 MBTI가 3개가 되므로
			// 최솟값은 0이됨.
			if(N > 16*2) {
				sb.append(0).append("\n");
				continue;
			}
			
			list = new ArrayList<>();
			for(int i = 0 ; i < N; i++) {
				list.add(st.nextToken());
			}
			v = new boolean[N];
			selected = new String[3];
			ans = Integer.MAX_VALUE;
			func(0, 0);
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static void func(int start, int cnt) {
		if(cnt == 3) {
			ans = Math.min(ans, dist());
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				selected[cnt] = list.get(i);
				func(i+1, cnt+1);
				v[i] = false;
			}
		}
	}
	
	static int dist() {
		int ret = 0;
		ret += calc(selected[0], selected[1]);
		ret += calc(selected[1], selected[2]);
		ret += calc(selected[2], selected[0]);
		return ret;
	}
	
	static int calc(String a, String b) {
		int ret = 0;
		for(int i = 0; i < 4; i++) {
			if(a.charAt(i) != b.charAt(i)) ret++;
		}
		return ret;
	}
	
}