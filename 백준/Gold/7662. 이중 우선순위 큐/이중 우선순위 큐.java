import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> {
		return -Integer.compare(o1, o2);
	});
	static PriorityQueue<Integer> minPQ = new PriorityQueue<>((o1, o2) -> {
		return Integer.compare(o1, o2);
	});
	static HashMap<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			while(!maxPQ.isEmpty()) maxPQ.poll();
			while(!minPQ.isEmpty()) minPQ.poll();
			map = new HashMap<>();
			// 각 테스트 데이터의 첫째 줄에는 Q에 적용할 연산의 개수를 나타내는 정수 k
			int k = Integer.parseInt(br.readLine());
			while (k-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char order = st.nextToken().charAt(0);
				int N = Integer.parseInt(st.nextToken());

				if (order == 'I') { // 삽입
					maxPQ.add(N);
					minPQ.add(N);
					map.put(N, map.getOrDefault(N, 0) + 1);
				} else { // 삭제
					// 만약 Q가 비어있는데 적용할 연산이 ‘D’라면 이 연산은 무시해도 좋다.
					if(map.isEmpty()) continue;
					if (N == 1) { // 최댓값 삭제
						del(true);
					} else { // 최솟값 삭제
						del(false);
					}
				}
			}

			// Q에 남아 있는 값 중 최댓값과 최솟값을 출력하라.
			// 두 값은 한 줄에 출력하되 하나의 공백으로 구분하라.
			// 만약 Q가 비어있다면 ‘EMPTY’를 출력하라.
			if (map.isEmpty())
				sb.append("EMPTY\n");
			else {
				int ans = del(true);
				sb.append(ans).append(" ");
				if(map.size()>0) ans = del(false);
				sb.append(ans).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}

	static int del(boolean max) {
		int num = 0;
		while (true) {
			if (max) num = maxPQ.poll();
			else num = minPQ.poll();

			int cnt = map.getOrDefault(num, 0);
			
			if(cnt==0) continue;
			if (cnt == 1) map.remove(num); // 1개 있다면 삭제
			else { // 더 많다면 map에서 -1함
				map.put(num, cnt - 1);
			}
			
			break;
		}
		return num;
	}
}