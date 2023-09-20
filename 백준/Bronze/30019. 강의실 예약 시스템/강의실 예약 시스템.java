import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int room = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(!map.containsKey(room)){
                sb.append("YES\n");
                map.put(room, e);
            }
            else{
                if(map.get(room) <= s){
                    sb.append("YES\n");
                    map.put(room, e);
                }
                else sb.append("NO\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}