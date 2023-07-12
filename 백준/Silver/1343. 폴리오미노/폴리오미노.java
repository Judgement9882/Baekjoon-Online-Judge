import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // 정규식
        // limit을 음수로 주면 모든 구분값을 나눔 => 공백 포함 가능
        String[] strArr = str.split("\\.", -1);
        StringBuilder sb = new StringBuilder();
        boolean ans = true;
        for(int i = 0 ; i < strArr.length; i++){
            String temp = strArr[i];
            int len = temp.length();
            if(len % 2 == 1) {
                ans = false;
                break;
            }

            while(len > 0){
                if(len >= 4) {
                    sb.append("AAAA");
                    len -= 4;
                }else if(len >= 2){
                    sb.append("BB");
                    len -= 2;
                }
            }
            if(i != strArr.length-1) sb.append(".");
        }
        if(ans) System.out.println(sb);
        else System.out.println(-1);
        br.close();
    }
}