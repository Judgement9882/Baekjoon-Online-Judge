import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int N = H+X, M = W+Y;
        int [][] A = new int[H][W];
        int [][] B = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 일단 A shape에 맞춰서 넣기
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                A[i][j] = B[i][j];
            }
        }

        // 겹치는 부분 빼기
        for(int i = X; i < H; i++){
            for(int j = Y; j < W; j++){
                A[i][j] -= A[i-X][j-Y];
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}