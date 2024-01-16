import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> rank = new ArrayList<>();
        ArrayList<Integer> rank2 = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            int index = Integer.parseInt(br.readLine());
            rank.add(index-1, i);
        }
        for(int i = M; i >= 1; i--){
            int index = Integer.parseInt(br.readLine());
            rank2.add(index-1, rank.get(i-1));
        }
        sb.append(rank2.get(0)).append("\n").append(rank2.get(1)).append("\n").append(rank2.get(2));
        System.out.println(sb);
        br.close();
    }
}