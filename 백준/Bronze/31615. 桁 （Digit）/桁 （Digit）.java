import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        if(A+B >= 100) sb.append(3);
        else if(A+B >= 10) sb.append(2);
        else sb.append(1);
        System.out.println(sb);
        br.close();
    }
}