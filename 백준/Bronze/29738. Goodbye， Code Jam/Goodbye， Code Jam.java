import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++){
            int temp = Integer.parseInt(br.readLine());
            sb.append("Case #").append(i).append(": ");
            if(temp <= 25) sb.append("World Finals\n");
            else if (temp <= 1000) sb.append("Round 3\n");
            else if (temp <= 4500) sb.append("Round 2\n");
            else sb.append("Round 1\n");
        }
        System.out.println(sb);
        br.close();
    }
}