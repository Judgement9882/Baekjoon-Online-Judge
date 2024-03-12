import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());
        while(X <= Y){
            sb.append("All positions change in year ").append(X).append("\n");
            X += 60;
        }
        System.out.println(sb);
        br.close();
    }
}