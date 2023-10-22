import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String tibutibuseal = br.readLine();
        int [] alpha = new int[26];
        for(int i = 0 ; i < N; i++){
            alpha[tibutibuseal.charAt(i)-'A']++;
        }
        int ans = alpha[1];
        ans = Math.min(ans, alpha[4]/2);
        ans = Math.min(ans, alpha[8]);
        ans = Math.min(ans, alpha[11]);
        ans = Math.min(ans, alpha[13]);
        ans = Math.min(ans, alpha[14]);
        ans = Math.min(ans, alpha[17]/2);
        ans = Math.min(ans, alpha[18]);
        ans = Math.min(ans, alpha[21]);
        ans = Math.min(ans, alpha[25]);
        System.out.println(ans);
        br.close();
    }
}
/*
A
    B
C
D
    E2
F
G
H
    I
J
K
    L
M
    N
    O
P
Q
    R2
    S
T
U
    V
W
X
Y
    Z
 */