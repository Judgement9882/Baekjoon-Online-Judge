import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//1
		int N = Integer.parseInt(br.readLine());
		int [][] time = new int[N][];
		
		//2
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");	
			int T = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			time[i] = new int[] {T, S};
		}
		
		Arrays.sort(time, (o1, o2) ->{
			return -Integer.compare(o1[1], o2[1]);
		});
		
		int early = time[0][1] - time[0][0];
		for(int i = 1 ; i < N; i++) {
			// 만약 시간이 끝나야 하는 시간보다 길다면 시간을 당기고 일을 진행
			if(early > time[i][1]) 
			   early = time[i][1] - time[i][0];
			// 아닐경우 그대로 일을 진행
			else early -= time[i][0];
		}
		// 만약 음수가 됐으면 할 수 없으므로 0 출력
		System.out.println(early<0?"-1":early);
		br.close();
	}
}