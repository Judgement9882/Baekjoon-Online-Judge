import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		ArrayDeque<Character> q = new ArrayDeque<>();
		int ans = 0;
		for(int i = 0; i < M; i++) {
			if(S.charAt(i) == 'O') {
				if(q.isEmpty()) continue; // 비어있으면 그냥 돌아감
				if(q.size() % 2 == 1) { // 사이즈가 홀수면 앞에 I가 있다는 것.
					q.offer('O');
				} else { // 짝수면 들어갈 수 없으므로 그냥 다 빼버림
					while(!q.isEmpty()) q.poll();
				}
			}else { // I
				if(q.isEmpty()) {
					q.offer('I');
					continue;
				}
				if(q.size() % 2 == 0) { // 짝수면 넣어도됨
					q.offer('I');
				}else { // 홀수면 들어갈 수 없으므로 다 빼버리고 I 하나를 넣음
					while(!q.isEmpty()) q.poll();
					q.offer('I');
				}
			}
			
			if(q.size() == 2*N + 1) {
				ans++;
				q.poll();
				q.poll();
			}
		}
				System.out.println(ans);
//		System.out.println(sb);
		br.close();
	}
}