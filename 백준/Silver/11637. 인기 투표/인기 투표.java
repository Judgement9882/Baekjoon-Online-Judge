import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            int [] vote = new int[n];
            int max_vote = 0;
            int max_index = 0;
            double sum_vote = 0.0;
            for(int i = 0; i < n; i++){
                int num = Integer.parseInt(br.readLine());
                vote[i] = num;
                sum_vote += num;

                if(max_vote < num){
                    max_vote = num;
                    max_index = i+1;
                }
            }
            sum_vote /= 2;
            // 중복 검사
            int rep = 0;
            for(int i = 0 ; i < n; i++){
                if(vote[i] == max_vote) rep++;
            }
            if(rep >= 2) sb.append("no winner\n");
            else{
                if(max_vote > sum_vote) sb.append("majority winner ").append(max_index).append("\n");
                else                    sb.append("minority winner ").append(max_index).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}