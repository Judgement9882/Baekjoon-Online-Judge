import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Double x = Double.parseDouble(st.nextToken());
            Double y = Double.parseDouble(st.nextToken());
            if(x == 0 || y == 0) sb.append("AXIS\n");
            else{
                if(x > 0){
                    if(y > 0) sb.append("Q1\n");
                    else if(y < 0) sb.append("Q4\n");
                }else{
                    if(y > 0) sb.append("Q2\n");
                    else if(y < 0) sb.append("Q3\n");
                }
            }
            if(x==0 && y==0) break;
        }
        System.out.println(sb);
        br.close();
    }
}