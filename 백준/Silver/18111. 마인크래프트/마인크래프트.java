import java.io.*;
import java.util.*;
public class Main {
	static int N, M, B;
	static int[] board;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		board = new int[257];
		int minH = 257;
		int maxH = 0;
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(minH > num) minH = num;
				if(maxH < num) maxH = num;
				board[num]++;
			}
		}
		StringBuilder sb = new StringBuilder();
		// 같은 경우 -> 처음부터 조건 만족
		if(minH==maxH) {
			sb.append(0).append(" ").append(minH);
		}
		else {
			int answerT = Integer.MAX_VALUE;
			int answerH = Integer.MAX_VALUE;
			height : for(int h = maxH; h >= minH; h--) { // 높이
				int num = B; // 사용가능한 블록 개수
				int time = 0; // 걸린 시간
				for(int i = maxH; i >= minH ; i--) { // 블록을 하나씩 들여다봄

					// 해당 높이의 블록이 있다면
					if(board[i] > 0) {
						// 1. 제거하여 인벤토리에 넣음 2초
						if(i > h) {
							time += 2*(board[i]*(i-h));
							num += board[i]*(i-h);
						}
						
						// 2. 블록 꺼내서 쌓음 1초
						else if (i < h) {
							time += board[i]*(h-i);
							num -= board[i]*(h-i);
						}
						
						if(num < 0) continue height;
					}
				}
				
				if(answerT > time) {
					answerT = time;
					answerH = h;
				}
			}
			sb.append(answerT).append(" ").append(answerH);
		}
		
		
		System.out.println(sb);
		br.close();
	}
}