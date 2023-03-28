import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> A = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		int left = 0;
		for(int i = 0 ;  i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
			left = Math.max(left, A.get(i));
		}
		
		int right = 1_000_000_000;
		
		while(left <= right) {
			int mid = (left+right)/2;
			int cnt = 0;
			int sum = 0;
			for(int i = 0; i < N; i++) {
				sum += A.get(i);
				if(sum > mid) {
					i--;
					cnt++;
					sum = 0;
				}
			}
			
			
			if(M > cnt) { // 합계가 K보다 작은경우
				// 상한을 줄여서 더 잘라야함
				right = mid-1;
			}else { // 합게가 M보다 크다? 키워서 더 자르지 말아야함
				left = mid+1;
			}
		}
		
		System.out.println(left);
		br.close();
	}
}