import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static List<Integer>[] magnet;
	static boolean [] connection;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		magnet = new List[4];
		// 입력
		for(int k = 0 ; k < 4; k++) {
			magnet[k] = new ArrayList<>();
			String temp = br.readLine();
			for(int i = 0 ; i < 8; i++) {
				magnet[k].add(temp.charAt(i) - '0');	
			}
		}
		N = Integer.parseInt(br.readLine());
		for(int order = 0 ; order < N; order++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken())-1; // 0 ~ 3
			int dir = Integer.parseInt(st.nextToken());
			
			// 1. 현재 연결 상태 확인 (0-1, 1-2, 2-3)
			connection = new boolean[3];
			checkConnection();
			
			// 2. 회전 (회전함수 구현)
			if(num == 0) {
				rotate(num, dir);
				for(int i = 0; i < 3; i++) {
					if(connection[i]) {
						dir *= -1;
						rotate(i+1, dir);
					}
					else break; // 하나라도 안된다면 바로 break
				}
			}
			else if (num == 3) {
				rotate(num, dir);
				for(int i = 2; i >= 0; i--) {
					if(connection[i]) {
						dir *= -1;
						rotate(i, dir);
					}
					else break; // 하나라도 안된다면 바로 break
				}
			}
			else if (num == 1) {
				rotate(num, dir);
				if(connection[0]) rotate(0, dir*-1);
				for(int i = 1; i < 3; i++) {
					if(connection[i]) {
						dir *= -1;
						rotate(i+1, dir);
					}
					else break; // 하나라도 안된다면 바로 break
				}
			}
			else if (num == 2) {
				rotate(num, dir);
				if(connection[2]) rotate(3, dir*-1);
				for(int i = 1; i >= 0; i--) {
					if(connection[i]) {
						dir *= -1;
						rotate(i, dir);
					}
					else break; // 하나라도 안된다면 바로 break
				}
			}
		}
		
		// 3. 점수 측정 
		int ans = 0;
		for(int n = 0; n < 4; n++) {
			ans += magnet[n].get(0)*(1<<n);
		}
			
		System.out.println(ans);
		br.close();
	}
	
	static void checkConnection() {
		// 0-1, 1-2, 2-3
		if(magnet[0].get(2) != magnet[1].get(6)) connection[0] = true;
		if(magnet[1].get(2) != magnet[2].get(6)) connection[1] = true;
		if(magnet[2].get(2) != magnet[3].get(6)) connection[2] = true;
	}
	
	static void rotate(int num, int dir) {
		if(dir == -1) { // 반시계
			int temp = magnet[num].get(0);
			magnet[num].remove(0);
			magnet[num].add(temp);
		}
		else { // 시계
			int temp = magnet[num].get(7);
			magnet[num].remove(7);
			magnet[num].add(0, temp);
		}
	}
}