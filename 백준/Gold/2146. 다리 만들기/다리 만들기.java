import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1,0,1,0}; // 상우하좌
    static int[] dc = {0,1,0,-1}; // 상우하좌
    
    static int N, min;
    static boolean[][] v;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 섬 번호 붙이기
        v = new boolean[N][N];
        int num = 2;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]==1) {
                    bfsNum(i, j, num);
                    num++;
                }
            }
        }
        
        // 다리 놓기 - 다리 최소값 찾기
        min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            v = new boolean[N][N];
            for(int j=0; j<N; j++) {
                if(!v[i][j] && map[i][j]>1) {
                    bfsBridge(i, j, map[i][j]);
                }
            }
        }
        System.out.println(min);
    }
    
    static void bfsNum(int i, int j, int num) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[] {i,j});
        map[i][j] = num;
        
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            
            for(int d=0; d<4; d++) {
                int ni = pos[0] + dr[d];
                int nj = pos[1] + dc[d];
                
                if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj] && map[ni][nj]==1) {
                    v[ni][nj] = true;
                    q.offer(new int[] {ni,nj});
                    map[ni][nj] = num;
                }
            }
        }
    }
    
    static void bfsBridge(int i, int j, int start) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[] {i,j});
        
        int size=0, depth=0;
        while(!q.isEmpty()) {
            size = q.size();
            
            while(size > 0) {
                int[] pos = q.poll();
                
                for(int d=0; d<4; d++) {
                    int ni = pos[0] + dr[d];
                    int nj = pos[1] + dc[d];
                    
                    // 범위 안에 있고, 방문하지 않았으면
                    if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj]) {
                        // 섬이고, 출발한 섬과 다른 섬이면
                        if(map[ni][nj] != 0 && start != map[ni][nj] ) {
                            min = Math.min(min, depth);
                            q.clear();
                            return;
                        }
                        else if(map[ni][nj] ==0) { // 바다이면 큐에 추가
                            v[ni][nj] = true;
                            q.offer(new int[] {ni,nj});
                        }
                    }
                }
                size--;
            }
            depth++;
        }
    }
}