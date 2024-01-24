import java.io.*;
import java.util.*;
public class Main {

    static boolean[] vis = new boolean[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] num = new int[1000001];
        int number = 1;
        for(int i = 1; i <= 1000000; i++){
            while(true){
                if(checkSuccessive(number)){
                    num[i] = number++;
                    break;
                }
                number++;
            }
        }

        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            sb.append(num[N]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    static boolean checkSuccessive(int N){
        // 00 이 반복되는 수
        if(N%100==0) return false;

        // init
        for(int i = 0; i < 10; i++) vis[i] = false;

        // calc
        while(N > 0){
            int index = N%10;
            if(vis[index]) return false;
            vis[index] = true;
            N/=10;
        }
        return true;
    }
}