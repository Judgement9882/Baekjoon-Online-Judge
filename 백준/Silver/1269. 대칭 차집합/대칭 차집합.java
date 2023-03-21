import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			map.put(temp, 1);
		}
		st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		for(int i = 0 ; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(map.containsKey(temp)) cnt++;
		}
		System.out.println(N+M-2*cnt);
		br.close();
	}
}