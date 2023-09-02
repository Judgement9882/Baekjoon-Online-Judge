import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] exchange = new int[100001];
        exchange[0] = 0;
        exchange[1] = exchange[3] = exchange[7] = exchange[9] = -1;
        exchange[2] = exchange[5] = 1;
        exchange[4] = 2;
        for(int i = 6; i <= N; i++){
            int val = Integer.MAX_VALUE;
            if(exchange[i-2] != -1) val = Math.min(val, exchange[i-2]+1);
            if(exchange[i-5] != -1) val = Math.min(val, exchange[i-5]+1);
            exchange[i] = val==Integer.MAX_VALUE?-1:val;
        }
        System.out.print(exchange[N]);
        br.close();
    }
}