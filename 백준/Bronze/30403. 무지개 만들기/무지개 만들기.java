import java.io.*;
import java.util.*;
public class Main {
    static char[] upRainbow = {'R', 'O', 'Y', 'G', 'B', 'I', 'V'};
    static char[] loRainbow = {'r', 'o', 'y', 'g', 'b', 'i', 'v'};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int alpha[] = new int['z'-'A'+1];
        for(int i = 0; i < N; i++){
            char temp = str.charAt(i);
            alpha[temp - 'A']++;
        }
//        for(int i = 0; i < 'z'-'A'; i++) {
//            System.out.println("index : " + i);
//            System.out.println(alpha[i]);
//        }
        boolean upper = true, lower = true;
        for(int i = 0 ; i < 7; i++){
            if(alpha[upRainbow[i] - 'A'] <= 0){
                upper = false;
                break;
            }
        }
        for(int i = 0 ; i < 7; i++){
            if(alpha[loRainbow[i] - 'A'] <= 0){
                lower = false;
                break;
            }
        }
        if(upper){
            if(lower) System.out.println("YeS");
            else System.out.println("YES");
        }
        else if(lower) System.out.println("yes");
        else System.out.println("NO!");
        br.close();
    }
}