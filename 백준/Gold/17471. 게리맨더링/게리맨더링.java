import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int N, ans, A_pop, B_pop;
	static List<Integer>[] Gu;
	static int [] population;
	static boolean[] v;
	
	static boolean isNotConnected() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		// A의 경우
		boolean [] A_v = new boolean[N];
		int A_temp = 0;
		for(int i = 0 ;i < N; i++) {
			if(v[i]) {
				A_v[i] = true;
				A_temp += population[i];
				q.offer(i);
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int i = q.poll();
			for(int j : Gu[i]) {
				// B영역이거나 방문했다면 continue
				if(!v[j] || A_v[j]) continue;
				A_v[j] = true; // A로 방문
				A_temp += population[j]; // 인구수 더하기
				q.offer(j);
			}
		}
		// 순회한 인구수가 다르다면 true
		if(A_temp != A_pop) return true;
		
		// B의 경우
		boolean [] B_v = new boolean[N];
		int B_temp = 0;
		for(int i = 0 ;i < N; i++) {
			if(!v[i]) {
				B_v[i] = true;
				B_temp += population[i];
				q.offer(i);
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int i = q.poll();
			for(int j : Gu[i]) {
				// A영역이거나 방문했다면 continue
				if(v[j] || B_v[j]) continue;
				B_v[j] = true; // A로 방문
				B_temp += population[j]; // 인구수 더하기
				q.offer(j);
			}
		}
		// 순회한 인구수가 다르다면 true
		if(B_temp != B_pop) return true;
		
		return false;
	}
	
	static void subs(int cnt) {
		if(ans == 0) return;
		
		if(cnt == N) {
			A_pop = 0;
			B_pop = 0;
			for(int i = 0 ;i < N; i++) {
				if(v[i]) A_pop += population[i];
				else B_pop += population[i];
			}
			// 구분이 안될경우 안됨.
			if(A_pop == 0 || B_pop == 0) return;
			// 나누어져 있는 경우 안됨.
			if(isNotConnected()) return;
			ans = Math.min(ans, Math.abs(A_pop - B_pop));
			return;
		}
		
		v[cnt] = true;
		subs(cnt+1);
		v[cnt] = false;
		subs(cnt+1);
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫째줄
        N = Integer.parseInt(br.readLine());
        Gu = new List[N]; 
        population = new int[N];
        
        // 둘째줄        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
        	Gu[i] = new ArrayList<>();
        	population[i] = Integer.parseInt(st.nextToken());
        }
        
        // 셋째 ~
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int R = Integer.parseInt(st.nextToken());
        	for(int m = 0 ; m < R; m++) {
        		int to = Integer.parseInt(st.nextToken()) - 1;
        		Gu[i].add(to);
        	}
        }
        
        ans = Integer.MAX_VALUE;
        v = new boolean[N];
        subs(0);
        System.out.println(ans==Integer.MAX_VALUE?"-1":ans);
        
        br.close();
    }
}