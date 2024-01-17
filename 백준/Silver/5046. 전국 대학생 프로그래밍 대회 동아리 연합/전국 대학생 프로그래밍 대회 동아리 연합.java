import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int money = Integer.MAX_VALUE;
        for(int i = 0 ; i < H; i++){
            int price = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < W; j++){
                int num = Integer.parseInt(st.nextToken());
                // 투숙 가능 인원이 더 적을 경우
                if(num < N) continue;
                if(N*price <= B) money = Math.min(money, N*price);
            }
        }
        System.out.println(money==Integer.MAX_VALUE?"stay home":money);

        br.close();
    }
}