import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> A = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");		
		for(int i = 0 ;  i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(A);
		int M = Integer.parseInt(br.readLine());
		
		int left = 0;
		int right = A.get(N-1);
		
		while(left <= right) {
			int mid = (left+right)/2;
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(mid >= A.get(i)) sum += A.get(i);
				else sum += mid;
			}
			
			if(M >= sum) { // 합계가 M보다 작거나 같은경우
				// left 를 늘림 => 예산 늘어남
				left = mid+1;
			}else { // 합게가 M보다 크다? 줄여야함
				right = mid-1;
			}
			
		}
		
		System.out.println(right);
		br.close();
	}
}