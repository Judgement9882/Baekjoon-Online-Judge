import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long ans = 1;
        int N = Integer.parseInt(br.readLine());
        for(int i = N; i > 10; i--) ans *= i;
        sb.append(ans*6);
        System.out.println(sb);
        br.close();
    }
}