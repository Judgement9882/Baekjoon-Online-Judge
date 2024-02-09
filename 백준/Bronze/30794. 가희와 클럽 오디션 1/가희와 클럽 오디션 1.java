import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = 0;
        String order = st.nextToken();
        if(order.equals("perfect"))     score = 1000;
        else if (order.equals("great")) score = 600;
        else if (order.equals("cool"))  score = 400;
        else if (order.equals("bad"))   score = 200;
        sb.append(n*score);
        System.out.print(sb);
        br.close();
    }
}