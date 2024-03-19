import java.io.*;
import java.util.*;
public class Main {
    static int [][][] arr = new int[101][101][101];
    static int CONST_VAL = 50;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1 && c==-1) break;
            sb.append("w(").append(a).append(", ").append(b)
                    .append(", ").append(c).append(") = ").append(w(a, b, c)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    // 기본 값이 0인데, 0이 나올 수 있으니 다른 값으로 초기화
    static void init(){
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                for(int k = 0; k < 101; k++){
                    arr[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
    }

    // 메모이제이션 활용하여 재귀 사용
    static int w(int a, int b, int c){
        // 있으면 있는거 리턴
        if(arr[a+CONST_VAL][b+CONST_VAL][c+CONST_VAL] != Integer.MAX_VALUE) return arr[a+CONST_VAL][b+CONST_VAL][c+CONST_VAL];

        if(a<=0 || b<=0 || c<=0) return 1;
        if(a>20 || b>20 || c>20) return arr[70][70][70] = w(20, 20, 20);
        if(a<b && b<c) {
            int temp_a = arr[a+CONST_VAL][b+CONST_VAL][c+CONST_VAL-1] = w(a, b, c-1);
            int temp_b = arr[a+CONST_VAL][b+CONST_VAL-1][c+CONST_VAL-1] = w(a, b-1, c-1);
            int temp_c = arr[a+CONST_VAL][b+CONST_VAL-1][c+CONST_VAL] = w(a, b-1, c);
            return temp_a + temp_b - temp_c;
        }
        else {
            int temp_a = arr[a+CONST_VAL-1][b+CONST_VAL][c+CONST_VAL] = w(a-1, b, c);
            int temp_b = arr[a+CONST_VAL-1][b+CONST_VAL-1][c+CONST_VAL] = w(a-1, b-1, c);
            int temp_c = arr[a+CONST_VAL-1][b+CONST_VAL][c+CONST_VAL-1] = w(a-1, b, c-1);
            int temp_d = arr[a+CONST_VAL-1][b+CONST_VAL-1][c+CONST_VAL-1] = w(a-1, b-1, c-1);
            return temp_a + temp_b + temp_c - temp_d;
        }
    }
}