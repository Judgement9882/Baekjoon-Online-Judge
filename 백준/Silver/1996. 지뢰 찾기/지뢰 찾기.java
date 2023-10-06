import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}, dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char [][] map = new char[N][N];
        int [][] ans = new int[N][N];
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != '.'){
                    ans[i][j] = -1;
                    for(int dir = 0; dir < 8; dir++){
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if(ans[nx][ny] == -1) continue; // 지뢰 처리
                        ans[nx][ny] += map[i][j] - '0';
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                     if(ans[i][j] == -1) sb.append("*");
                else if(ans[i][j] >= 10) sb.append("M");
                else sb.append(ans[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}