import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		
		// B에 대한 전처리
		if(B % 2 == 1) { // 홀수면서
			if(B % 10 != 1) { // 끝자리가 1이 아니면 어떻게해도 못만듦
				System.out.println("-1");
				return;
			}
		}
		
		int cnt = 1;
		ArrayDeque<Long> q= new ArrayDeque<>();
		q.offer(A);
		cnt++;
		end : while(true) {
			if(q.isEmpty()) {
				cnt = -1;
				break;
			}
			int q_size = q.size();
				for(int i = 0 ; i < q_size; i++) {
				long cur = q.poll();
				long n = cur*2;
				if(n==B) break end;
				if(n > B) continue; 
				q.offer(n);
				
				n = cur*10+1;
				if(n==B) break end;
				if(n > B) continue; 
				q.offer(n);
			}
			cnt++;
		}
		System.out.println(cnt);
		br.close();
	}
}
