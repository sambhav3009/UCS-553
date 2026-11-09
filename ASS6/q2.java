import java.io.*;

public class q2 {

    static void makeLogFile(String name) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {
            String[] lines = {
                "2026-11-07 10:00:01 INFO Application started",
                "2026-11-07 10:00:05 INFO User admin logged in",
                "2026-11-07 10:01:12 WARNING Disk usage above 80%",
                "2026-11-07 10:02:30 INFO Fetching records from database",
                "2026-11-07 10:03:45 ERROR Database connection timeout",
                "2026-11-07 10:04:10 INFO Retrying connection",
                "2026-11-07 10:04:15 INFO Connection re-established",
                "2026-11-07 10:05:50 WARNING Response time exceeded 2s",
                "2026-11-07 10:06:20 ERROR NullPointerException in ReportService",
                "2026-11-07 10:07:00 INFO User admin logged out"
            };
            for (String s : lines) {
                bw.write(s);
                bw.newLine();
            }
            System.out.println("Log file created: " + name);
        } catch (IOException e) {
            System.out.println("Could not create log file: " + e.getMessage());
        }
    }

    static void checkLogs(String inFile, String outFile) {
        int total = 0, err = 0, warn = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                total++;

                if (line.contains("ERROR")) {
                    err++;
                    bw.write(line);
                    bw.newLine();
                } else if (line.contains("WARNING")) {
                    warn++;
                    bw.write(line);
                    bw.newLine();
                }
            }

            bw.newLine();
            bw.write("Total entries: " + total);
            bw.newLine();
            bw.write("ERROR count: " + err);
            bw.newLine();
            bw.write("WARNING count: " + warn);
            bw.newLine();

            System.out.println("\nTotal entries: " + total);
            System.out.println("ERROR count: " + err);
            System.out.println("WARNING count: " + warn);
            System.out.println("Filtered lines saved in " + outFile);

        } catch (FileNotFoundException e) {
            System.out.println("Log file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    static void printFile(String name) {
        System.out.println("\nContents of " + name + ":");
        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        makeLogFile("app.log");
        checkLogs("app.log", "errors_warnings.txt");
        printFile("errors_warnings.txt");
    }
}
