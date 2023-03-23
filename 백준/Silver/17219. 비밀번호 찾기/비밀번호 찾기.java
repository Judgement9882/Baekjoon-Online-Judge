import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<>();
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String id = st.nextToken();
			String pw = st.nextToken();
			map.put(id, pw);
		}
		for(int i = 0; i < M; i++) {
			String id = br.readLine();
			System.out.println(map.get(id));
		}
		br.close();
	}
}