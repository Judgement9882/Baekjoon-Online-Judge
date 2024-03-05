import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int W = Integer.parseInt(br.readLine());
        sb.append(8*((int) Math.sqrt(W/2)));
        System.out.println(sb);
        br.close();
    }
}