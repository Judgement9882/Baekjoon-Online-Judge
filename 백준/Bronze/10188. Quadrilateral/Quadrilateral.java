import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    sb.append("X");
                }
                sb.append("\n");
            }
            if(N!=0) sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}