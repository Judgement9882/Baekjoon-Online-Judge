import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> track = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(N-->0){
            char c = st.nextToken().charAt(0);
            track.put(c, track.getOrDefault(c, 0)+1);
        }
        char c = br.readLine().charAt(0);
        sb.append(track.get(c) == null ? 0 : track.get(c));
        System.out.print(sb);
        br.close();
    }
}