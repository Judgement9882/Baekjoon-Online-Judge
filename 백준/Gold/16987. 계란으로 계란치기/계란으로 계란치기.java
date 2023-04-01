import java.io.*;
import java.util.*;

public class Main {
	static int N, ans;
	static Egg[] eggs;

	static class Egg {
		int s;
		int w;

		public Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(s, w);
		}

		if (N == 1)
			System.out.println(0);
		else {
			ans = 0;
			solve(0);
			System.out.println(ans);
		}
		br.close();
	}

	static void solve(int idx) {

		// 0번째 계란을 선택한 상태에서 깨트릴 i번째 계란을 순열로 정함
		if (idx == N) { // 제일 오른쪽 계란이면 종료
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (eggs[i].s <= 0)
					cnt++; // 깨진 계란 카운트
			}
			ans = Math.max(ans, cnt);
			return;
		}

		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if(i == idx) continue; // 자기자신은 안함
			// 둘 다 내구도 0 초과
			if(eggs[idx].s > 0 && eggs[i].s > 0) {
				eggs[idx].s -= eggs[i].w;
				eggs[i].s -= eggs[idx].w;
				
				flag = true; // 박았음
				solve(idx+1);
				
				eggs[idx].s += eggs[i].w;
				eggs[i].s += eggs[idx].w;
			}
		}
		if(!flag) solve(idx+1); // 계란을 칠 수 없으면 그냥 넘어감
	}
}