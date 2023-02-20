import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		List<Integer> fruits = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			fruits.add(temp);
		}
		
		Collections.sort(fruits);
		
		for(int i = 0 ; i < N; i++) {
			if(fruits.get(i) <= L) L++;
			else break;
		}
		
		System.out.println(L);
		
		
		
		br.close();
	}
}
