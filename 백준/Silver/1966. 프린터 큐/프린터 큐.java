import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
		
		int T = Integer.parseInt(st.nextToken());
		flag : for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(),  " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			ArrayDeque<int[]> q = new ArrayDeque<>();
			
			int max_num = 0;
			int [] impo = new int[10]; // 중요도 개수 저장
			
			// 입력
			st = new StringTokenizer(br.readLine(),  " ");
			for(int i = 0  ; i < N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				q.offer(new int[] {temp, i});
				impo[temp]++;
				max_num = Math.max(max_num, temp);
			}
			
			int cnt = 1;
			while(!q.isEmpty()) {
				int temp [] = q.poll();
				// 만약 큐의 값이 최대값과 같다면?
				if(max_num == temp[0]) {
					// 만약 인덱스 값과 같다면? 종료
					if(M == temp[1]) {
						System.out.println(cnt);
						continue flag;
					}
					
					cnt++; // 개수 증가
					impo[max_num]--; // max_num 빼기
					while(impo[max_num] <= 0) {
						max_num--;
					}
				}
				
				// 같지 않다면 뒤로 넣기
				q.offer(temp);
			}
		}
		
		br.close();
	}
}
