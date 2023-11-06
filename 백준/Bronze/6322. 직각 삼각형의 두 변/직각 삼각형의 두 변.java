import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(++index > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==0 && b == 0 && c ==0) break;

            double answer = 0.0;
            String ans = " ";
            if(c!= -1 && (a>=c || b>=c)) ans = "Impossible.";
            else {
                if (a == -1) {
                    if (c * c - b * b >= 0) {
                        answer = Math.sqrt(c * c - b * b);
                        ans = "a = " + String.format("%.3f", answer);
                    } else {
                        ans = "Impossible.";
                    }
                } else if (b == -1) {
                    if (c * c - a * a >= 0) {
                        answer = Math.sqrt(c * c - a * a);
                        ans = "b = " + String.format("%.3f", answer);
                    } else {
                        ans = "Impossible.";
                    }
                } else if (c == -1) {
                    answer = Math.sqrt(a * a + b * b);
                    ans = "c = " + String.format("%.3f", answer);
                }
            }
            sb.append("Triangle #").append(index).append("\n")
                    .append(ans).append("\n\n");
        }
        System.out.println(sb);
        br.close();
    }
}