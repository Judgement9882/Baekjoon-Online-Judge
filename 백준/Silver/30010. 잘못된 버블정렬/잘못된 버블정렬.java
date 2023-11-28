import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 3; i <= N; i++){
            sb.append(i).append(" ");
        }
        sb.append("1 2");
        System.out.println(sb);
        br.close();
    }
}