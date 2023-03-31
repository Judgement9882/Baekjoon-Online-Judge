import java.util.*;
import java.io.*;
public class Main {
	static int N, C, low, high;
	static int [] home;
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		home = new int[N];
		for(int i = 0 ; i < N;i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);
		System.out.println(solve());
		br.close();
	}
	
	static int solve() {
		low = 1;
		high = home[N-1] - home[0] + 1; // 공유기는 2개 이상  -> 최소한 시작점과 끝점은 공유기 설치 가능해야함.
		while(low < high) {
			int mid = low + (high-low)/2;
			
			if(countDevice(mid) < C) { 
				// 공유기 설치 가능 집이 C보다 작으면 더 설치해야 하므로 범위를 줄임
				high = mid;
			}
			
			else {
				// N과 같거나 크면 거리를 늘려가며 최대 거리를 찾음
				low = mid+1;
			}
			
		}
		
		return low-1;
	}
	
	static int countDevice(int dist) {
		
		int cnt = 1;
		int lastRegist = home[0]; // 첫번째 집은 무조건 가능
		
		for(int i = 1; i < home.length; i++) {
			if(home[i] - lastRegist >= dist) {
				// i번째 집과 가장 최근 공유기 설치한 집의 거리가 dist 이상이면 가능
				lastRegist = home[i];
				cnt++;
			}
		}
		return cnt;
	}
}