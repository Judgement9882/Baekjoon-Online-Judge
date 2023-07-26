import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append("Class ").append(i).append("\n");
            StringTokenizer st= new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] score = new int[num];
            for(int j = 0; j < num; j++){
                score[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(score);

            int max_gap = 0;
            for(int j = 0; j < num-1; j++){
                max_gap = Math.max(max_gap, score[j+1] - score[j]);
            }

            sb.append("Max ").append(score[num-1]).append(", ");
            sb.append("Min ").append(score[0]).append(", ");
            sb.append("Largest gap ").append(max_gap).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}