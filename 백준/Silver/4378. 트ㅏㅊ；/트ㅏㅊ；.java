import java.io.*;
import java.util.*;
public class Main {
    static HashMap<Character, Character> taza = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();

        String str = "";
        while((str = br.readLine()) != null) {
            for (int i = 0; i < str.length(); i++) {
                Character c = taza.get(str.charAt(i));
                if (c != null) sb.append(c);
                else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static void init(){
        taza.put('1', '`');
        taza.put('2', '1');
        taza.put('3', '2');
        taza.put('4', '3');
        taza.put('5', '4');
        taza.put('6', '5');
        taza.put('7', '6');
        taza.put('8', '7');
        taza.put('9', '8');
        taza.put('0', '9');
        taza.put('-', '0');
        taza.put('=', '-');

        taza.put('W', 'Q');
        taza.put('E', 'W');
        taza.put('R', 'E');
        taza.put('T', 'R');
        taza.put('Y', 'T');
        taza.put('U', 'Y');
        taza.put('I', 'U');
        taza.put('O', 'I');
        taza.put('P', 'O');
        taza.put('[', 'P');
        taza.put(']', '[');
        taza.put('\\', ']');

        taza.put('S', 'A');
        taza.put('D', 'S');
        taza.put('F', 'D');
        taza.put('G', 'F');
        taza.put('H', 'G');
        taza.put('J', 'H');
        taza.put('K', 'J');
        taza.put('L', 'K');
        taza.put(';', 'L');
        taza.put('\'', ';');

        taza.put('X', 'Z');
        taza.put('C', 'X');
        taza.put('V', 'C');
        taza.put('B', 'V');
        taza.put('N', 'B');
        taza.put('M', 'N');
        taza.put(',', 'M');
        taza.put('.', ',');
        taza.put('/', '.');
    }
}