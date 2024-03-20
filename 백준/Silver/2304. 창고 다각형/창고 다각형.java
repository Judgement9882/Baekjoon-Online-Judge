import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int [] area = new int[1001]; // 범위 1000
        int start_x = Integer.MAX_VALUE;
        int end_x = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            area[x] = height; // 해당 지역 높이
            start_x = Math.min(start_x, x);
            end_x = Math.max(end_x, x);
        }

        // stack에 넣고 처리
        ArrayDeque<Integer> stack  = new ArrayDeque<>();

        // 왼쪽
        int cur_height = area[start_x];
        for(int i = start_x+1; i <= end_x; i++){
            // 이전 값보다 작을 경우, 해당 인덱스 stack에 넣기
            if(cur_height > area[i]) stack.push(i);
            else{ // 클 경우, stack에 있는 작은 인덱스에 갱신
                while(!stack.isEmpty()){
                    int cur_x = stack.pop();
                    area[cur_x] = cur_height;
                }
                // 갱신 끝난 후에는 현재 높이를 새로운 높이로 갱신
                cur_height = area[i];
            }
        }
        stack.clear();

        // 오른쪽
        cur_height = area[end_x];
        for(int i = end_x-1; i >= start_x; i--){
            // 이전 값보다 작을 경우, 해당 인덱스 stack에 넣기
            if(cur_height > area[i]) stack.push(i);
            else{ // 클 경우, stack에 있는 작은 인덱스에 갱신
                while(!stack.isEmpty()){
                    int cur_x = stack.pop();
                    area[cur_x] = cur_height;
                }
                // 갱신 끝난 후에는 현재 높이를 새로운 높이로 갱신
                cur_height = area[i];
            }
        }
        stack.clear();

        int ans = 0;
        for(int i = start_x; i <= end_x; i++) ans += area[i];
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}