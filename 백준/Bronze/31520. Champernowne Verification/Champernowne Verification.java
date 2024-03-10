import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int ans = -1;
        String str = br.readLine();
        String [] arr = {"1", "12", "123", "1234", "12345", "123456", "1234567", "12345678", "123456789"};
        for(int i = 1; i <= 9; i++){
            if(str.equals(arr[i-1])) {
                ans = i;
                break;
            }
        }
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}