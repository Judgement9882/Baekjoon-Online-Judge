import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		HashSet<Integer> S = new HashSet<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < A; i++) {
			S.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < B; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(S.contains(num)) S.remove(num);
		}
		System.out.println(S.size());
		Object[] arr = S.toArray();
		Arrays.sort(arr);
		for(Object i : arr) System.out.print(i+" ");
		br.close();
	}
}