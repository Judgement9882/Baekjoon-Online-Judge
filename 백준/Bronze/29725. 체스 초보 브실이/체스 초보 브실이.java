import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 8;
        int ans = 0;
        while(num-->0){
            String line = br.readLine();
            for(int i = 0 ; i < 8; i++){
                char ch = line.charAt(i);
                switch (ch){
                    case 'P':
                        ans += 1;
                        break;
                    case 'p':
                        ans -= 1;
                        break;
                    case 'N':
                        ans += 3;
                        break;
                    case 'n':
                        ans -= 3;
                        break;
                    case 'B':
                        ans += 3;
                        break;
                    case 'b':
                        ans -= 3;
                        break;
                    case 'R':
                        ans += 5;
                        break;
                    case 'r':
                        ans -= 5;
                        break;
                    case 'Q':
                        ans += 9;
                        break;
                    case 'q':
                        ans -= 9;
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.print(ans);
        br.close();
    }
}