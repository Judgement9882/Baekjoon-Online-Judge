import java.util.*;
import java.io.*;

public class Main{
	
	static int[] board;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 입력
		int N = Integer.parseInt(st.nextToken());
		
		// 스위치 설정
		board = new int[N+1];
		
		// 입력
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) board[i] = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			
			// 남학생인경우
			if(gender == 1) {
				// 배수를 XOR 연산
				for(int j = index ; j <= N; j += index) board[j] ^= 1; 
			}
			
			// 여학생인경우
			else if (gender == 2) {
				// 우선 index을 XOR연산
				board[index] ^= 1;
				
				// 한 칸 씩 이동하면서 체크
				int left = index-1, right = index+1;
				while(true) {
					// 경계값 처리
					if(left <= 0 || right > N) break;
					
					// 같지 않으면 break
					if(board[left] != board[right]) break;
					
					// 해당 값을 switch 하고 left--, right++
					board[left--] ^= 1;
					board[right++] ^= 1;
				}
			}
//			// 20개의 스위치 출력 후 한 줄 띄우기
//			for(int m = 1 ; m <= N; m++) {
//				System.out.print(board[m] + " ");
//				if(m % 20 == 0) System.out.println();
//			}
//			System.out.println();
		}
		// 20개의 스위치 출력 후 한 줄 띄우기
		for(int m = 1 ; m <= N; m++) {
			System.out.print(board[m] + " ");
			if(m % 20 == 0) System.out.println();
		}

	}
}
