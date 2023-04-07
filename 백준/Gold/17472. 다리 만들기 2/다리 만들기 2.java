import java.io.*;
import java.util.*;

public class Main {
    static int[][] map, link;
    static int[] di= {-1,0,1,0}, dj= {0,1,0,-1}; //상우하좌
    static int N, M;
    static boolean[][] v;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        v = new boolean[N][M];
        int num = 1;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]==1 && !v[i][j]) {
                    bfs(i,j,num);
                    num++;
                }
            }
        }
        link = new int[num-1][num-1]; //섬 갯수만큼 배열 만들어서
        for(int i=0;i<N;i++)
            available_link(map[i], M);
        for(int i=0;i<M;i++) {
            int[] arr = new int[N];
            for(int j=0;j<N;j++) arr[j] = map[j][i];
            available_link(arr, N);
        } //각 행, 열마다 만들 수 있는 다리 체크해서 다리 길이 link 배열에 넣기
        
        //Prim 알고리즘
        boolean[] vertex = new boolean[num-1];
        int[] minEdge = new int[num-1];
        for(int i=0;i<num-1;i++) //{
//            System.out.println(Arrays.toString(link[i]));
            minEdge[i] = Integer.MAX_VALUE;
//        }
//        System.out.println();
        int result = 0, cnt = 0;
        minEdge[0]=0;
        for(int i=0;i<num-1;i++) {
            int minVertex = -1;
            int min = Integer.MAX_VALUE;
            for(int j=0;j<num-1;j++) {
                if(!vertex[j] && min>minEdge[j]) {
                    minVertex=j;
                    min = minEdge[j];
                }
            }
            if(minVertex==-1) break;
            vertex[minVertex] = true;
            if(cnt++ == num-2) break;
            for(int j=0;j<num-1;j++) {
                if(!vertex[j] && link[minVertex][j]!=0 && minEdge[j]>link[minVertex][j])
                    minEdge[j]=link[minVertex][j];
            }
//            System.out.println(Arrays.toString(minEdge));
        }
        for(int i=1;i<num-1;i++) {
            if(minEdge[i]==Integer.MAX_VALUE) { //하나라도 MAX값이면 -1저장하고 break
                result=-1;
                break;
            }
            result+=minEdge[i]; //다리 길이 합 저장
        }
        System.out.println(result);
        
        br.close();
    }
    static void bfs(int x, int y, int n) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x,y});
        v[x][y]=true;
        map[x][y]=n;
        while(!q.isEmpty()) {
            int[] ij = q.poll();
            for(int d=0;d<4;d++) {
                int ni = ij[0]+di[d];
                int nj = ij[1]+dj[d];
                if(ni>=0 && nj>=0 && ni<N && nj<M && !v[ni][nj] && map[ni][nj]==1){
                    v[ni][nj]=true;
                    map[ni][nj]=n;
                    q.offer(new int[] {ni,nj});
                }
            }
        }
    }
    static void available_link(int[] arr, int size) {
        int start = 0, end = 0;
        while(true) {
            end++;
            if(end>=size) break;
            if(arr[start]==arr[end]) continue;
            
            if(arr[start]==0) start=end;
            else {
                start=end;
                while(true) {
                    end++;
                    if(end>=size || arr[start]!=arr[end]) break;
                }
                start--;
            }
            if(end>=size) break;
            
            int a = arr[start];
            int b = arr[end];
            if(a>0 && b>0 && a!=b && end-start-1>1) {
                if(link[a-1][b-1]==0) {
                    link[a-1][b-1]=end-start-1;
                    link[b-1][a-1]=end-start-1;
                } else {
                    link[a-1][b-1]=Math.min(link[a-1][b-1], end-start-1);
                    link[b-1][a-1]=Math.min(link[b-1][a-1], end-start-1);
                }
            }
            start=end;
        }
    }
}