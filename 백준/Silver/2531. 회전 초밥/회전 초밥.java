import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int [] plate = new int[N+k]; // 마지막에서 연속된 순서를 볼려고
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			plate[i] = num;
		}
		
		int [] sushi = new int[d+1]; // 먹은 초밥 개수 저장
		sushi[c]++; // 쿠폰으로 무조건 먹음
		int ans = 0, kind = 1; // 답과 먹을 수 있는 가짓수
		
		
		for(int i = N; i < N+k; i++) {
			// 최초 k길이만큼 연속으로 먹기
			if( sushi[plate[i-N]] == 0) { // 0이면 아직 먹지 않았음 -> 가짓수 증가
				kind++;
			}
			sushi[plate[i-N]]++;
			
			plate[i] = plate[i-N]; // 뒷부분 저장
		}
		ans = Math.max(ans, kind);
		// 한칸씩 슬라이딩
		for(int i = k; i < N+k; i++) {
			// 삭제
			if(sushi[plate[i-k]] == 1) { // 빼야할 종류가 1이었다면 종류수 감소
				kind--;
			}
			sushi[plate[i-k]]--;
			
			// 추가
			if( sushi[plate[i]] == 0) { // 0이면 아직 먹지 않았음 -> 가짓수 증가
				kind++;
			}
			sushi[plate[i]]++;
			
			ans = Math.max(ans, kind);	
		}
		System.out.println(ans);		
		br.close();
	}
}