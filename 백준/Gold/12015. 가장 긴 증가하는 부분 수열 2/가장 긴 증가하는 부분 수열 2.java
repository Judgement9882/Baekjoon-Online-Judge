import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int [] A = new int[N+1];
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> dp = new ArrayList<>();
		int last = 0;
		
		dp.add(A[1]);
		for(int i = 2; i<= N; i++) {
			
			// 이진탐색 풀이
			// 새로 들어온 값이 dp 배열의 끝보다 작다면
			// 이진탐색을 통해 들어갈 수 있는 자리에 넣음
			if(A[i] > dp.get(last)) { // dp에 마지막에 저장된 수보다 큰 경우
				// 갱신하지 않고 dp에 추가함
				last++;
				dp.add(A[i]);
			}
			else { // 저장된 수보다 작거나 같을경우 이진탐색
				int idx = Collections.binarySearch(dp, A[i]);
				if(idx < 0) dp.set(Math.abs(idx)-1, A[i]);
				
			}
		}
		System.out.println(dp.size());
		br.close();
	}
}