import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[][] friends = new boolean[N][N];
		boolean[][] dp = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				if(line.charAt(j) == 'Y') {
					dp[i][j] = true;
					friends[i][j] = true;
				}
				else {
					dp[i][j] = false;
					friends[i][j] = false;
				}
			}
		}

		int ans = 0;
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i==j) continue;
					if(friends[i][k] && friends[k][j]) dp[i][j] = true;
				}
			}
		}

		for(int i=0; i<N; i++) {
			int cnt = 0;
			for(int j=0; j<N; j++) {
				if(dp[i][j]) cnt++;
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}