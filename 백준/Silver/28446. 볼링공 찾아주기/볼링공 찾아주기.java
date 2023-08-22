import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        // 무게 -> 사물함번호
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order == 2){
                sb.append(map.get(Integer.parseInt(st.nextToken()))).append("\n");
            }
            else{
                int x = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                map.put(w, x);
            }
        }
        System.out.print(sb);
        br.close();
    }
}