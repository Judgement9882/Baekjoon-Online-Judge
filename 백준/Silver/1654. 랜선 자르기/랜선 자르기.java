import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> A = new ArrayList<>();
		for(int i = 0 ;  i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A.add(Integer.parseInt(st.nextToken()));
		}
//		Collections.sort(A);
		
		
		long left = 0;
		long right = Integer.MAX_VALUE;
		
		while(left <= right) {
			long mid = (left+right)/2;
			long sum = 0;
			for(int i = 0; i < N; i++) {
				sum += A.get(i)/mid;
			}
			
			
			if(K > sum) { // 합계가 K보다 작은경우
				// 상한을 줄여서 더 잘라야함
				right = mid-1;
			}else { // 합게가 M보다 크다? 키워서 더 자르지 말아야함
				left = mid+1;
			}
		}
		
		System.out.println(right);
		br.close();
	}
}