import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean ans = false;
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        if(A==B+C) ans = true;
        if(B==A+C) ans = true;
        if(C==B+A) ans = true;
        sb.append(ans?1:0);
        System.out.println(sb);
        br.close();
    }
}