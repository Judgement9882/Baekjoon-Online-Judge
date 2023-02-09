import java.io.*;
import java.util.*;

public class Main{
	
	static int N, M, K, x, y, z, ans = 0;
	static int[][] board, A;
	//어떤 칸 (r, c)와 인접한 칸은 (r-1, c-1), (r-1, c), (r-1, c+1), 
//	(r, c-1), (r, c+1), (r+1, c-1), (r+1, c), (r+1, c+1) 이다.
	
	static final int [] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static final int [] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
//	static ArrayDeque<Tree> dq = new ArrayDeque<>();
//	static PriorityQueue<Tree> pq = new PriorityQueue<>();
	static ArrayDeque<Tree> q = new ArrayDeque<>();
	static ArrayDeque<Tree> dead = new ArrayDeque<>();
	
	static class Tree implements Comparable<Tree>{
		int z; // 나이
		int x;
		int y;
		
		Tree(int z, int x, int y){
			this.z = z;
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.z, o.z);
		}
	}
	/*
	 
	 */ 
	static void spring() {
		int q_size = q.size();
		for(int i = 0; i < q_size; i++) {
			Tree cur = q.poll();
			
			// 나이가 양분보다 더 많은 경우
			// 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
			if(cur.z > board[cur.x][cur.y]) {
				dead.add(cur);
				continue;
			}
			
			// 양분이 충분한 경우
			// 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
			board[cur.x][cur.y] -= cur.z;
			cur.z++;
			q.add(cur);
		}
	}
	
	// 여름에는 봄에 죽은 나무가 양분으로 변하게 된다. 
	//각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 
	static void summer() {
		while(!dead.isEmpty()) {
			Tree cur = dead.poll();
			board[cur.x][cur.y] += cur.z/2;
		}
	}
	
 


	static void fall() {
		ArrayDeque<Tree> temp = new ArrayDeque<>();
		int q_size = q.size();
		for(int i = 0 ; i < q_size; i++) {
			Tree cur = q.poll();
			
//			번식하는 나무는 나이가 5의 배수이어야 하며,
			if(cur.z % 5 == 0) {
				temp.add(cur);
			}
			q.add(cur);
		}
		
		while(!temp.isEmpty()) {
			Tree cur = temp.poll();
			
			for(int i = 0; i < 8; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
//				 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
				if(nx <= 0 || nx > N || ny <= 0 || ny > N) continue;
				
//				인접한 8개의 칸에 나이가 1인 나무가 생긴다. 
				q.addFirst(new Tree(1, nx, ny));
			}
		}
	}
	// 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다. 
	// 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
	static void winter() {
		for(int i =1 ; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				board[i][j] += A[i][j];
			}
		}
	}
	
	static void func() {
		int year = 0;
		while(true) {
			// K년이 지났다면
			if(year == K) {
				// ans 개수 출력
				System.out.println(q.size());
				break;
			}
			// 봄
			spring();
			// 여름
			summer();
			// 가을
			fall();
			// 겨울
			winter();
			year++;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 첫째 줄 입력
		N = Integer.parseInt(st.nextToken()); // 보드 크기
		M = Integer.parseInt(st.nextToken()); // 나무의 개수
		K = Integer.parseInt(st.nextToken()); // 연도
		
		board = new int[N+1][N+1];
		A = new int[N+1][N+1];
		
		// 둘째 줄 입력
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");	
			for(int j = 1; j <= N ; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				board[i][j] = 5;
			}
		}
		
		// 셋째 줄 입력
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
//			pq.add(new Tree(z, x, y));
			q.add(new Tree(z, x, y));
		}
		
//		while(!pq.isEmpty()) {
//			q.add(pq.peek());
//			pq.remove();
//		}
		
		func();
	}
}
