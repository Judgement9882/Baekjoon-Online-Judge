import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<int[]> score = new ArrayList<>();
		for(int i = 1; i <= 8; i++) score.add(new int[] {Integer.parseInt(br.readLine()), i});
		Collections.sort(score, (o1, o2) ->{
			return -Integer.compare(o1[0], o2[0]);
		});
		ArrayList<Integer> participant = new ArrayList<>();
		int ans = 0;
		for(int i = 0; i < 5; i++) {
			ans += score.get(i)[0];
			participant.add(score.get(i)[1]);
		}
		Collections.sort(participant);
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append("\n");
		for(int num : participant) sb.append(num).append(" ");
		System.out.println(sb);
		br.close();
	}
}