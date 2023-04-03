import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] topni;
	static int[] canRotate;
	static int K, ans;
	
	static void solve() {
		for(int i = 0;i < 4; i++) {
			if(topni[i].get(0) == 1) {
				ans += (1 << i);
			}
		}
	}

	static void Rotate() {
		for (int i = 0; i < 4; i++) {
			int dir = canRotate[i];

			// 시계방향
			if(dir == 1) {
				int temp = topni[i].get(7);
				topni[i].add(0, temp);
				topni[i].remove(8);
			}
			
			// 반시계방향
			else if (dir == -1) {
				int temp = topni[i].get(0);
				topni[i].add(temp);
				topni[i].remove(0);
			}
		}
	}

	static void checkCanRotate(int num, int dir) {
		canRotate[num] = dir;

		// 왼쪽 확인
		for (int i = num - 1; i >= 0; i--) {
			// 왼쪽의 2번과 오른쪽의 6번이 다르다면?
			if (topni[i].get(2) != topni[i + 1].get(6)) {
				canRotate[i] = canRotate[i + 1] * (-1);
			} else
				break;
		}

		// 오른쪽 확인
		for (int i = num + 1; i < 4; i++) {
			// 왼쪽의 2번과 오른쪽의 6번이 다르다면?
			if (topni[i - 1].get(2) != topni[i].get(6)) {
				canRotate[i] = canRotate[i - 1] * (-1);
			} else
				break;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		topni = new ArrayList[4];
		for (int i = 0; i < 4; i++) {
			topni[i] = new ArrayList<>();

			String temp = br.readLine();
			for (int j = 0; j < 8; j++) {
				topni[i].add(temp.charAt(j) - '0');
			}
		}

		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			canRotate = new int[4];

			checkCanRotate(num, dir);
			Rotate();
		}
		ans = 0;
		solve();
		System.out.println(ans);
		br.close();
	}
}