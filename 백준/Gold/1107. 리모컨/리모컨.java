import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 채널
		int M = Integer.parseInt(br.readLine()); // 고장난 버튼 개수
		int ans = Integer.MAX_VALUE;
		boolean [] button = new boolean[10]; // 고장나면 true
		if(M>0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(M-->0) {
				button[Integer.parseInt(st.nextToken())] = true;
			}
		}
		ans = Math.min(Math.abs(N-100), ans); // 현재 채널
		
		// 0 ~ 1,000,000 수 확인 (N=500,000 기준 -N, +N)
		for(int i = 0; i <= 1_000_000; i++) {
			if(checkCanChannel(Integer.toString(i), button)) {
				ans = Math.min(Math.abs(N-i)+Integer.toString(i).length(), ans);
			}
		}
		System.out.println(ans);
		br.close();
	}
	
	static boolean checkCanChannel(String str, boolean[] button) {
		for(int i = 0; i < str.length(); i++) {
			if(button[str.charAt(i) - '0']) return false; // true면 고장
		}
		return true;
	}
}