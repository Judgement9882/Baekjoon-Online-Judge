import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 1; i < str.length(); i++){
            for(int j = i+1; j < str.length(); j++){
                // str |(i) str |(j) str
                StringBuilder temp = new StringBuilder();
                StringBuilder sb1 = new StringBuilder(str.substring(0, i));
                StringBuilder sb2 = new StringBuilder(str.substring(i, j));
                StringBuilder sb3 = new StringBuilder(str.substring(j, str.length()));
                temp.append(sb1.reverse()).append(sb2.reverse()).append(sb3.reverse());
                arr.add(temp.toString());
            }
        }
        Collections.sort(arr);
        System.out.println(arr.get(0));
//        System.out.println(sb);
        br.close();
    }
}