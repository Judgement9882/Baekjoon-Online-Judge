import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        if(N==1) System.out.print(0);
        else if(N==2) System.out.print(2);
        else if(N==3) System.out.print(3);
        else{
            int ans = 3;
            int prev = 2;
            for(int i = 4; i <= N; i++){
                int temp = ans;
                ans += prev;
                ans %= 10;
                prev = temp;
            }
            System.out.print(ans);
        }
        br.close();
    }
}
/*
     1 - 0
     2 - 0-1, 1-1 (2C0 + 1C1) = 2
     3 - 0-1, 1-2, (3C0 + 2C1) = 3
     4 - 0-1, 1-3, 2-1 (4C0 + 3C1 + 2C2) = 5
     5 - 0-1, 1-4, 2-3 (5C0 + 4C1 + 3C2) = 8
     6 - 0-1, 1-5, 2-6, 3-1
     nC0 + n-1C1 + n-2C2 + n-3C3 = 13


 */