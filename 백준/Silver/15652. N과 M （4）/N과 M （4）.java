import java.io.*;
import java.util.*;
public class Main {

    static int N, M, C;
    static int[] arr, selected;
//    static boolean[] vis; // 순열에만 필요
    static StringBuilder sb = new StringBuilder();
//    static void perm(int cnt){
//        if(cnt == M){
//            for(int j = 0; j < M; j++){
//                sb.append(selected[j]).append(" ");
//            }
//            sb.append("\n");
//            return;
//        }
//
//        for(int i = 0; i < N; i++){
////            if(vis[i]) continue;
////            vis[i] = true;
//            selected[cnt] = arr[i];
//            perm(cnt+1);
////            vis[i] = false;
//        }
//    }

    static void comb(int cnt, int start){
        if(cnt == M){
            for(int j = 0; j < M; j++){
                sb.append(selected[j]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++){
            selected[cnt] = arr[i];
//            comb(cnt+1, i+1);
            comb(cnt+1, i);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = i+1;
        selected = new int[M];
//        vis = new boolean[N];
//        perm(0);
        comb(0, 0);

        System.out.println(sb);
        br.close();
    }
}