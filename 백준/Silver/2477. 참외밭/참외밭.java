import java.io.*;
import java.util.*;
public class Main {
    static class Info{
        int dir;
        int len;
        Info(int dir, int len){
            this.dir = dir;
            this.len = len;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());

        // 방향 정보
        int [] dir_info = new int[5];

        // 들어온 순서
        ArrayList<Info> order = new ArrayList<>();

        int N = 6;
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            dir_info[dir]++;
            order.add(new Info(dir, len));
        }

        // 1. 개수가 하나인 변 찾기
        int bigSquare = 1;
        int dir1 = 0, dir2 = 0;

        for(int i = 1; i <= 4; i++){
            if(dir_info[i] == 1) {
                for(Info temp : order){
                    if(temp.dir == i){
                        bigSquare *= temp.len;
                    }
                }
            }
            else{ // 2. 개수 2개 변 저장
                if(dir1==0) dir1=i;
                else dir2=i;
            }
        }

        int smallSquare = 1;
        // 3. 끼인 변 찾기
        for(int i = 0; i < order.size(); i++){
            if(order.get(i).dir == dir1){
                if(order.get((i-1)<0?5:i-1).dir == dir2 && order.get((i+1)>5?0:i+1).dir == dir2){
                    smallSquare *= order.get(i).len;
                }
            }
            else if(order.get(i).dir == dir2){
                if(order.get((i-1)<0?5:i-1).dir == dir1 && order.get((i+1)>5?0:i+1).dir == dir1){
                    smallSquare *= order.get(i).len;
                }
            }
        }
        sb.append((bigSquare - smallSquare)*K);
        System.out.println(sb);
        br.close();
    }
}