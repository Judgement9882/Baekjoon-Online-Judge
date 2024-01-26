import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(char c : noun) set.add(c);
        while(true){
            String password = br.readLine();
            if(password.equals("end")) break;
            sb.append("<").append(password).append(">").append(" is ").append(rule(password) == true? "" : "not ").append("acceptable.\n");
        }
        System.out.println(sb);
        br.close();
    }

    static boolean rule(String str){
        boolean rule1 = false;
        end : for(char c : noun){
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == c){
                    rule1 = true;
                    break end;
                }
            }
        }
        if(!rule1) return false;

        int rep = 1;
        boolean flag = false; // true -> noun
        for(char c : noun){
            if(str.charAt(0) == c) {
                flag = true;
                break;
            }
        }


        for(int i = 0 ; i < str.length()-2; i++){
            char a = str.charAt(i);
            char b = str.charAt(i+1);
            char c = str.charAt(i+2);
            boolean ca = false;
            boolean cb = false;
            boolean cc = false;
            // noun -> true
            if(set.contains(a)) ca = true;
            if(set.contains(b)) cb = true;
            if(set.contains(c)) cc = true;
            if(ca && cb && cc) {
//                sb.append("false : " + a + b + c).append("\n");
//                sb.append("false : " + ca + cb + cc).append("\n");
                return false;
            }
            if(!ca && !cb && !cc) {
//                sb.append("false2 : " + a + b + c).append("\n");
//                sb.append("false2 : " + ca + cb + cc).append("\n");
                return false;
            }
        }

        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                if(str.charAt(i) != 'e' && str.charAt(i) != 'o') return false;
            }
        }

        return true;
    }

    static HashSet<Character> set = new HashSet<>();
    static char [] noun = {'a', 'e', 'i', 'o', 'u'};
}