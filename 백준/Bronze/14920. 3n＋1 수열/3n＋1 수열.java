import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(N);
        if(N==1){
            System.out.println("1");
        }else {
            int ans = 1;
            while (true) {
                int num = dp.get(ans - 1);
                int in = 0;
                if (num % 2 == 0) in = num / 2;
                else in = 3 * num + 1;
                if (in == 1) break;
                dp.add(in);
                ans++;
            }
            System.out.println(ans + 1);
        }
        br.close();
    }
}