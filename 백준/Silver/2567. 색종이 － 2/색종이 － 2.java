import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		
		/*
		 * 둘레의 길이를 구하는 방식은 검은 스카프의 위치가 주어졌을 때,
		 * 해당 위치의 상, 좌, 우, 하 값이 흰색 스카프인 경우를 더하면 됩니다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼 선언
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 토큰화를 위한 선언
		int N = Integer.parseInt(st.nextToken()); // 스카프의 수
		
		/*
		 * 검은 스카프가 천 밖으로 나가는 일은 없지만
		 * 크기를 100*100으로 선언하면, 테두리에 있는 검은 스카프는
		 * 주위의 흰색 스카프를 카운트 할 수 없으므로
		 * 1부터 시작하는 인덱스를 사용하며, 흰색, 검은색 스카프는 1~101
		 * 0, 102 인덱스는 테두리를 처리하기 위한 구역으로 두어
		 * 배열을 103*103로 설정하였습니다.
		 */
		boolean [][] board = new boolean[103][103];
		
		/*
		 * 매 탐색마다 100*100 탐색을 하는 것 보다, 입력받은 검은색 스카프의 
		 * 최대 행, 열의 길이를 구해서 거기까지만 탐색을 진행해도 됩니다.
		 */
		int row_len = 0, col_len = 0; // 최대 행, 최대 열
		for(int m = 0 ; m < N; m++) { // N번 반복
			st = new StringTokenizer(br.readLine(), " "); // 다음 줄 토큰화

			// 테두리 처리를 위해 입력값은 +1 을 해줬습니다.
			int x = Integer.parseInt(st.nextToken())+1; 
			int y = Integer.parseInt(st.nextToken())+1;
			
			// 반복문을 돌면서 내부를 채웁니다.
			for(int i = x ; i < x+10; i++) {
				for(int j = y ; j < y+10; j++) {
					board[i][j] = true; 
				}
			}
			
			// 최대 행, 열을 갱신합니다.
			row_len = Math.max(row_len, x+10);
			col_len = Math.max(col_len, y+10);
		}
		
		int [] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0}; // 상 좌 우 하

		int cnt = 0; // 둘레를 저장할 변수
		
		// 1부터 시작하여 true인 i,j를 확인합니다.
		// 알맞은 범위 내에서 탐색하므로 영역 예외처리는 하지않습니다.
		for(int i = 1 ; i < row_len; i++) {
			for(int j = 1 ; j < col_len; j++) {
				// true라면 진행
				if(board[i][j]) {
					// 4방향을 탐색합니다
					for(int dir = 0 ; dir < 4; dir++) {
						int nx = i + dx[dir]; // 다음 x 좌표
						int ny = j + dy[dir]; // 다음 y 좌표
						
						// 주변에 인접한 칸이 0이라면 cnt++ 
						if(!board[nx][ny]) cnt++;
					}
				}
			}
		}
		// 둘레를 출력합니다.
		System.out.println(cnt);
		br.close(); // 버퍼드리더 종료
	}
}
