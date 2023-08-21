import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            HashSet<String> set = new HashSet<>();
            while(N-->0){
                set.add(br.readLine());
            }
            sb.append(set.size()).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}