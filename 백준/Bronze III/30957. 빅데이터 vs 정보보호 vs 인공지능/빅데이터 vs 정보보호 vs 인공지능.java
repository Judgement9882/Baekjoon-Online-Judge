import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char alphabet[] = new char[26];
        String str = br.readLine();
        for(int i = 0 ; i < N; i++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                alphabet[str.charAt(i)-'A']++;
            }
        }
        int B = alphabet[1];
        int S = alphabet[18];
        int A = alphabet[0];

        int max = B;
        max = Math.max(max, S);
        max = Math.max(max, A);

        int cnt = 0;
        if(max==B) cnt++;
        if(max==S) cnt++;
        if(max==A) cnt++;

        if(cnt==3) sb.append("SCU");
        else if (cnt==2){
            if(B==S) sb.append("BS");
            else if (B==A) sb.append("BA");
            else sb.append("SA");
        }else{
            if(max==B) sb.append("B");
            else if (max==S) sb.append("S");
            else sb.append("A");
        }


        System.out.println(sb);
        br.close();
    }
}