import java.io.*;
import java.util.*;

public class Main{
	
	static int[][] table;
	static List<int[]> pair;
	static int[][] isused;
	static StringBuilder sb = new StringBuilder();
	static boolean possible;
	static boolean table_possible;
	// 해당 배열로 table에 들어갈 수 있는지 확인
	static boolean isAvailable(int cnt) {
		for(int i = 0; i < 6; i++) {
			if(cnt == i) continue;
			// 비어있을경우
			if(table[i][cnt] == 0) {
				table[i][cnt] = -table[cnt][i];
			}
			else {
				// 승패무
				if(table[cnt][i] != -table[i][cnt]) return false;
			}
		}
		return true;
	}
	
	static void printTable() {
		System.out.println();
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void perm(int cnt, int index) {
		if(table_possible) return;
		
		if(index == 5) {
			int isusedindex = 0;
			// 이전에 들어온 값이 일치하지 않는다면 return
			for(int i = 0; i < cnt; i++) {
				if(table[cnt][i] != isused[cnt][isusedindex++]) return;
			}
			
			isusedindex = cnt;
			for(int i = cnt+1 ; i < 6; i++) {
				table[cnt][i] = isused[cnt][isusedindex];
				table[i][cnt] = -isused[cnt][isusedindex++];
			}
			// 열과 동일한지 체크
//			isused = new int[5];
			perm(cnt+1, 0);
//			printTable();
//			System.out.println("isused");
//			for(int x = 0; x < 6; x++) {
//				for(int j = 0; j < 5; j++) {
//					System.out.print(isused[x][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			return;
		}
		
		if(cnt == 6) {
			// 테이블 완성
			table_possible = true;
			return;
		}
		
		for(int i = 0 ; i < 3; i++) {
			if(pair.get(cnt)[i] > 0) {
				pair.get(cnt)[i]--;
				isused[cnt][index] = i-1;
				perm(cnt, index+1);
				if(table_possible) return;
				pair.get(cnt)[i]++;
			}
		}
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 4;
		
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = 6, win = 0, lose = 0;
			pair = new ArrayList<>();
			possible = true;
			table_possible = false;
			table = new int[6][6];
			
			for(int i = 0 ; i < N; i++) {
				int a = Integer.parseInt(st.nextToken());
				if(a>5) possible = false;
				win += a;
				
				int b = Integer.parseInt(st.nextToken());
				if(b>5) possible = false;
				
				int c = Integer.parseInt(st.nextToken());
				if(c>5) possible = false;
				lose += c;
				
				pair.add(new int[] {a, b, c});
				// 1. 3개 합이 5가 아닌 경우
				if(a+b+c != 5) possible = false;
			}
			// 2. win과 lose의 수가 같지 않은 경우
			if(win != lose) possible = false;

			isused = new int[6][5];
			if(possible) perm(0, 0);
			sb.append(table_possible?"1 ":"0 ");
		}
		System.out.println(sb);
		br.close();
	}
}
