import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int M = Integer.parseInt(br.readLine());
			sb.append(M/2 + 1).append("\n");
			
			// 중간값보다 작은 pq (최대힙)
			PriorityQueue<Integer> pqLeft = new PriorityQueue<>(
					(o1, o2) -> {return -Integer.compare(o1, o2);}
			);
			
			// 중간값보다 큰 pq (최소힙)
			PriorityQueue<Integer> pqRight = new PriorityQueue<>(
					(o1, o2) -> {return Integer.compare(o1, o2);}
			);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 최초 1회
			int ans = Integer.parseInt(st.nextToken());
			sb.append(ans).append(" ");
			int repeat = M/2; // 반복횟수
			int tenInput = 1; // 한 줄에 10개씩 입력
			int tenOutput = 1; // 한 줄에 10개씩 출력
			while(repeat-- > 0) {
				for(int i = 0; i < 2; i++) {
					int num = Integer.parseInt(st.nextToken());
					if(num <= ans) pqLeft.add(num);
					else if (ans <= num) pqRight.add(num);
					if(++tenInput==10) {
						st = new StringTokenizer(br.readLine());
						tenInput = 0;
					}
				}
				// 작은 수가 더 많다면
				if(pqLeft.size() > pqRight.size()) {
					// 1. ans를 pqRight에 넣음
					pqRight.add(ans);
					// 2. pqLeft에서 하나 꺼낸 것을 ans로
					ans = pqLeft.poll();
				}
				// 큰수가 더 많다면
				else if (pqLeft.size() < pqRight.size()) { 
					// 1. ans를 pqLeft에 넣음
					pqLeft.add(ans);
					// 2. pqRight에서 하나 꺼낸 것을 ans로
					ans = pqRight.poll();
				}
				// 두 pq의 크기가 동일하다면 그대로 ans 출력, 작업 이후 ans 출력
				sb.append(ans).append(" ");
				if(++tenOutput==10) {
					sb.append("\n");
					tenOutput = 0;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}