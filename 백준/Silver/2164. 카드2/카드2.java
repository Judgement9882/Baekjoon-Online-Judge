import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i= 1 ; i <= N; i++) {
			q.add(i);
		}
		
		ArrayDeque<Integer> temp = new ArrayDeque<>();
		while(!(q.size()==1)) {
			q.poll();
			temp.add(q.poll());
			q.add(temp.poll());
		}
		System.out.println(q.poll());
	}
}
