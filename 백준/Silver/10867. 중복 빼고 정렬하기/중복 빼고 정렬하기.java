import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean [] v = new boolean[2002];
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(!v[temp+1000]) {
				v[temp+1000] = true;
				list.add(temp);
			}
		}
		Collections.sort(list);
		for(int i : list) System.out.print(i + " ");
		br.close();
	}
}