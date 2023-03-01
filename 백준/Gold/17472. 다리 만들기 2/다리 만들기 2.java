import java.io.*;
import java.util.*;

public class Main{
	static int N, M, contCnt, ans;
	static int[][] board;
	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
	static int[] p; // 대륙의 부모를 저장하는 배열
	static ArrayDeque<int[]> q = new ArrayDeque<>();
	static PriorityQueue<Edge> edges;
	
	static class Edge implements Comparable<Edge>{
		int from, to, dist;
		public Edge(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
	
	static void makeSet(int size) {
		p = new int[size + 1];
		for (int i = 0; i <= size; i++)
			p[i] = i;
	}

	static int findSet(int a) {
		if (a == p[a])
			return a;
		return p[a] = findSet(p[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		p[bRoot] = aRoot;
		return true;
	}

	// 낮은 거리 순으로 체크
	static void solve() {
		// 1. p 초기화
		makeSet(contCnt);
		
		// 2. 정렬 -> pq는 이미 되어있음
		// 3. 다리 길이 구하기
		
		int conn = 0;
		int temp_ans = 0;
		while(!edges.isEmpty()) {
			Edge cur = edges.poll();
			// 만약 union 가능하면 진행
			if(union(cur.from, cur.to)) {
				temp_ans += cur.dist;
				if(++conn == contCnt - 1) {
					ans = Math.min(ans, temp_ans);
					break;
				}
			}
		}
	}
	
	// 출발 - 도착 거리 구하기
	static void dist(int x, int y, int color) {
		for(int d = 0; d < 4 ; d++) {
			int nx = x;
			int ny = y;
			int cnt = 0;
			while(true) {
				nx += dx[d];
				ny += dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					break;
				// 같은 색이 나오면 추가하지 않음
				if(board[nx][ny] == color)
					break;
				
				// 다른 색이 나오면 그게 최솟값.
				if(board[nx][ny] != 0) {
					// 만약 거리가 2 미만이면 추가안함
					if(cnt < 2) break;
					
					// 출발, 도착, 거리
					edges.offer(new Edge(color, board[nx][ny], cnt));
					break;
				}
				
				// 바다면 다리 길이 늘림
				cnt++;
			}
		}
	}

	static void bfs(int x, int y, int color) {
		board[x][y] = color;
		q.offer(new int[] { x, y });
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (board[nx][ny] != -1)
					continue;

				board[nx][ny] = color;
				q.offer(new int[] { nx, ny });
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				// 육지는 -1
				board[i][j] = -Integer.parseInt(st.nextToken());
			}
		}

		// 같은 영역 확인
		int area = 1;
		contCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == -1) {
					bfs(i, j, area++);
					contCnt++;
				}
			}
		}
		
		// 거리 구하기
		edges = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] != 0) {
					dist(i, j, board[i][j]);
				}
			}
		}
		

		ans = Integer.MAX_VALUE;
		solve();
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
		br.close();
	}
}
