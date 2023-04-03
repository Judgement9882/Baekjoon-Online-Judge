import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		test : for(int tc = 0; tc < T; tc++) {
			// n
			int n = Integer.parseInt(br.readLine());
			
			// home
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int [] home = new int[] {x, y};
			
			// shop
			ArrayList<int[]> shop = new ArrayList<>();
			for(int i = 0 ; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				shop.add(new int[] {x, y});
			}
			
			// festival
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			int [] fest = new int[] {x, y};
			
			// 만약 집에서 페스티벌까지 바로 갈 수 있다면
			if(calcDist(home[0], fest[0], home[1], fest[1]) <= 1000) {
				sb.append("happy\n");
			}else {
				ArrayDeque<int[]> q = new ArrayDeque<>();
				q.offer(new int[] {home[0], home[1]});
				
				while(!q.isEmpty()) {
					int cur[] = q.poll();
//					System.out.println(cur[0]);
					for(int i = shop.size()-1 ; i >= 0; i--) {
						int temp[] = shop.get(i);
						// 현재 위치에서 갈 수 있다면
						if(calcDist(cur[0], temp[0], cur[1], temp[1]) <= 1000) {  
							// 그 위치가 페스티벌 까지 갈 수 있다면
							if(calcDist(fest[0], temp[0], fest[1], temp[1]) <= 1000) {
								sb.append("happy\n");
								continue test;
							}
							// 갈수 없다면 큐에 넣고 돌림
							q.offer(new int[] {temp[0], temp[1]});
							
							// 방문 처리를 리스트에서 제거하는 형식으로함
							shop.remove(i);
						}
					}
				}
				sb.append("sad\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
	
	static int calcDist(int x, int y, int i, int j) {
		return Math.abs(x-y)+Math.abs(i-j);
	}
}