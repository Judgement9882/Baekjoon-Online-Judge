// chatgpt
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mapping from codes to demerit points
        Map<String, Integer> codeToPoints = new HashMap<>();
        codeToPoints.put("TT", 75);
        codeToPoints.put("TX", 50);
        codeToPoints.put("PR", 80);
        codeToPoints.put("RT", 30);
        codeToPoints.put("AP", 25);
        codeToPoints.put("PX", 60);

        while (true) {
            // Read week number and number of entries
            int weekNumber = scanner.nextInt();
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (weekNumber == 0 && n == 0) {
                break; // Terminate on "0 0"
            }

            // Track demerit points for each student
            Map<String, Integer> studentPoints = new LinkedHashMap<>();

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String name = parts[0];
                String code = parts[1];

                int points = codeToPoints.getOrDefault(code, 0);
                studentPoints.put(name, studentPoints.getOrDefault(name, 0) + points);
            }

            // Collect names of students with >= 100 points
            List<String> confiscated = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : studentPoints.entrySet()) {
                if (entry.getValue() >= 100) {
                    confiscated.add(entry.getKey());
                }
            }

            // Output results for the week
            System.out.print("Week " + weekNumber + " ");
            if (confiscated.isEmpty()) {
                System.out.println("No phones confiscated");
            } else {
                System.out.println(String.join(",", confiscated));
            }
        }

        scanner.close();
    }
}