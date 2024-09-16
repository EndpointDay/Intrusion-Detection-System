import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final int FAILED_LOGIN_THRESHOLD = 5;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <log-file>");
            return;
        }

        String logFilePath = args[0];
        try {
            analyzeLogs(logFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void analyzeLogs(String filePath) throws IOException {
        Map<String, Integer> loginAttempts = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length < 3) {
                    continue;
                }

                String ip = parts[1];
                String action = parts[2];

                if ("FAILED".equalsIgnoreCase(action)) {
                    loginAttempts.put(ip, loginAttempts.getOrDefault(ip, 0) + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : loginAttempts.entrySet()) {
            if (entry.getValue() >= FAILED_LOGIN_THRESHOLD) {
                System.out.println("Suspicious activity detected from IP: " + entry.getKey());
                System.out.println("Failed login attempts: " + entry.getValue());
            }
        }
    }
}
