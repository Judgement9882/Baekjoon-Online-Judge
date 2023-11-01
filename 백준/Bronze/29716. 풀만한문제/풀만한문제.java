import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int J = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int ans = N;
        while(N-->0){
            int score = 0;
            String temp = br.readLine();
            for(int i = 0 ; i < temp.length(); i++){
                int c = temp.charAt(i) - '0';
                if(c >= 'A'-'0' && c <= 'Z'-'0') score+=4;
                else if (c >= 'a'-'0' && c <= 'z'-'0') score += 2;
                else if (c >= 0 && c <= 9) score += 2;
                else score++;
            }
//            System.out.println(temp + score);
            if(score > J) ans--;
        }
        System.out.println(ans);
        br.close();
    }
}