import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Score> arr = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				arr.add(new Score(s, m));
			}
			Collections.sort(arr, (o1, o2) ->{
				return Integer.compare(o1.s, o2.s);
			});
			
			// 서류 1등은 무조건
			int ans = 1;
			// 비교대상은 내 위에 있는 사람들의 면접 순위 중 가장 큰 값
			int comp = arr.get(0).m;
			// 2등부터 시작
			for(int i = 1; i < N; i++) {
				// i번째 사람의 면접순위
				int i_m = arr.get(i).m;
				if(comp > i_m) { // 비교 대상보다 순위가 낮다면 합격
					ans++;
					comp = i_m; // 갱신
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static class Score{
		int s;
		int m;
		Score(int s, int m){
			this.s = s;
			this.m = m;
		}
	}
}