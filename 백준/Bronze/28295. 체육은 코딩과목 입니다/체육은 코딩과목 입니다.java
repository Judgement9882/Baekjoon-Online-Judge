import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 최초는 북쪽
        int ans = 0;
        // 10개 지시
        int num = 10;
        while(num-->0){
            int order = Integer.parseInt(br.readLine());
            if(order == 1) ans++;
            else if (order == 2) ans+=2;
            else if (order == 3) ans+=3;
            ans %= 4;
        }
        if(ans==0) System.out.print('N');
        else if(ans==1) System.out.print('E');
        else if(ans==2) System.out.print('S');
        else if(ans==3) System.out.print('W');
        br.close();
    }
}