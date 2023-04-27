import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String temp = st.nextToken();
			String act = st.nextToken();
			if(act.equals("enter")) {
				set.add(temp);
			}
			else if (act.equals("leave")) {
				set.remove(temp);
			}
		}

		Object[] arr = set.toArray();
		Arrays.sort(arr);
		for(int i = arr.length-1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
		br.close();
	}
}