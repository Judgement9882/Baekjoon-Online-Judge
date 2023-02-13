import java.util.*;


import java.io.*;

public class Main{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		ArrayDeque<int[]> s = new ArrayDeque<>();
		
		// 처음엔 0 추가
		sb.append(0).append(" ");
		s.push(new int[] {Integer.parseInt(st.nextToken()), 1});
		
		for(int i = 2; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// 새로운게 이전거보다 작으면? 넣음
			if(num <= s.peek()[0]) {
				sb.append(s.peek()[1]).append(" ");
				s.push(new int[] {num, i});
			}
			
			// 크거나 같으면 신호 못받음 -> pop하고 닿는걸 찾음
			else {
				while(!s.isEmpty() && num >= s.peek()[0]) {
					s.pop();
				}
				
				// 비었을 경우
				if(s.isEmpty()) {
					sb.append(0).append(" ");
					s.push(new int[] {num, i});
				}
				else { // 있는 경우
					sb.append(s.peek()[1]).append(" ");
					s.push(new int[] {num, i});
				}
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
}
