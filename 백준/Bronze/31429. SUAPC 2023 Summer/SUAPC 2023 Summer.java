import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int num[] = {12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6};
        int panelty[] = {1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773};
        sb.append(num[N-1]).append(" ").append(panelty[N-1]);
        System.out.println(sb);
        br.close();
    }
}