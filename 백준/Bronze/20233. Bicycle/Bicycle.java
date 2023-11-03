import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        int option1Cost = calculateCost(a, x, T, 30);
        int option2Cost = calculateCost(b, y, T, 45);

        System.out.println(option1Cost + " " + option2Cost);
        br.close();
    }

    static int calculateCost(int monthlyFee, int costPerMinute, int totalMinutes, int freeMinutes) {
        int totalCost = monthlyFee;

        if (totalMinutes > freeMinutes) {
            totalCost += (totalMinutes - freeMinutes) * costPerMinute * 21;
        }

        return totalCost;
    }
}