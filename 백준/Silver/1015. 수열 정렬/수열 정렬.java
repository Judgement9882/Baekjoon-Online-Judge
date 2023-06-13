import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList <int[]> A = new ArrayList<>();
		int [] B = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			A.add(new int[] {temp, i});
		}
		
		Collections.sort(A, (o1, o2)->{
			return Integer.compare(o1[0], o2[0]);
		});
		
		for(int i = 0 ; i < N; i++) {
			B[A.get(i)[1]] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int b: B) {
			sb.append(b).append(" ");
		}
		System.out.println(sb);
		
		br.close();
	}
}