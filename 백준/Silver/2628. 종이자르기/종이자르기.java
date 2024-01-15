import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(br.readLine());
        int row[] = new int[N];
        int col[] = new int[M];
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            if(order==0)    row[index] = 1;
            else            col[index] = 1;
        }

        int max_row = 0;
        int max_col = 0;
        int temp_row = 0;
        int temp_col = 0;

        for(int i = 0 ; i < N; i++){
            if(row[i] == 1) {
                max_row = Math.max(max_row, temp_row);
                temp_row = 1;
            }else temp_row++;
        }
        max_row = Math.max(max_row, temp_row);

        for(int i = 0 ; i < M; i++){
            if(col[i] == 1) {
                max_col = Math.max(max_col, temp_col);
                temp_col = 1;
            }else temp_col++;
        }
        max_col = Math.max(max_col, temp_col);

        System.out.println(max_row * max_col);
        br.close();
    }
}