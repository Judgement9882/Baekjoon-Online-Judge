import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<String> arr = new ArrayList<>();
            for(int j = 0; j < 3; j++){
                arr.add(st.nextToken());
            }
            Collections.sort(arr);
            StringBuilder sb = new StringBuilder();
            for(String temp : arr){
                sb.append(temp).append(" ");
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
            answer = Math.max(answer, map.get(sb.toString()));
        }
        System.out.print(answer);
        br.close();
    }
}