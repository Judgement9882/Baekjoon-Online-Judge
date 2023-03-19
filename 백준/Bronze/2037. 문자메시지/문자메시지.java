import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int p, w;
		p = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		int alphabet[] = new int[26];
		int parent[] = new int[26];
		int [] first = new int[] {0, 3, 6, 9, 12, 15, 19, 22};
		for(int i : first) {
			alphabet[i] = p;
			alphabet[i+1] = 2*p;
			alphabet[i+2] = 3*p;
			
			parent[i] = i;
			parent[i+1] = i;
			parent[i+2] = i;
		}
		// S와 Z 처리
		alphabet[18] = 4*p;
		alphabet[25] = 4*p;
		
		parent[18] = 15;
		parent[25] = 22;
		
		String msg = br.readLine();
		
		int ans = 0;
		// 첫번째 수 처리 (공백 아님)
		int index = msg.charAt(0) - 'A';
		ans +=  ans += alphabet[index];
		
		for(int s = 1; s < msg.length(); s++) {
			int pre_index = msg.charAt(s-1) - 'A';
			index = msg.charAt(s) - 'A';
			
			// 공백 처리(인덱스 에러)
			if(msg.charAt(s-1) == ' ' || msg.charAt(s) == ' ') {}
			// 같은 부모면 w를 더해서 버튼을 초기화하고 진행
			else if (parent[index] == parent[pre_index]) ans+=w;
			
			// 공백이면 그냥 누르면 됨
			if(msg.charAt(s) == ' ') ans += p;			
			else ans += alphabet[index];
		}
		System.out.println(ans);
		br.close();
	}
}