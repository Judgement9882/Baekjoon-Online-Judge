import java.io.*;
import java.util.*;
public class Main {

    static String[] strList= {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};;
    static class Number{
        String num;
        int real_num;
        public Number(String num, int real_num) {
            this.num = num;
            this.real_num = real_num;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Number> list = new ArrayList<>();
        for(int i = M; i <= N; i++){
            list.add(new Number(retStr(i), i));
        }

        Collections.sort(list, (o1, o2)->{
           return o1.num.compareTo(o2.num);
        });

        StringBuilder ans = new StringBuilder();
        for(int i = 1; i <= N-M+1; i++){
            ans.append(list.get(i-1).real_num).append(" ");
            if(i % 10 == 0) ans.append("\n");
        }
        System.out.print(ans.toString());
        br.close();
    }

    static String retStr(int num){
        StringBuilder sb = new StringBuilder();
        if(num<10) sb.append(strList[num]);
        else{
            sb.append(strList[num/10]).append(" ");
            sb.append(strList[num%10]);
        }
        return sb.toString();
    }
}