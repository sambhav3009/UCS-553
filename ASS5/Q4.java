import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter event name: ");
        String name = sc.nextLine();
        System.out.print("Enter event date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.print("Enter start time (HH:MM): ");
        LocalTime startTime = LocalTime.parse(sc.nextLine());
        System.out.print("Enter venue (leave empty if not specified): ");
        String venueInput = sc.nextLine();
        Optional<String> venue = Optional.ofNullable(
                venueInput.isEmpty() ? null : venueInput
        );
        LocalTime endTime = startTime.plusHours(2);
        LocalDate today = LocalDate.now();
        System.out.println("\nEvent Details");
        System.out.println("Event Name: " + name);
        System.out.println("Event Date: " + date);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        System.out.println("Venue: " + venue.orElse("Venue not specified"));
        if (date.isAfter(today)) {
            System.out.println("Event Status: Future");
        } else if (date.isEqual(today)) {
            System.out.println("Event Status: Today");
        } else {
            System.out.println("Event Status: Past");
        }
        long daysRemaining = ChronoUnit.DAYS.between(today, date);
        System.out.println("Days Remaining: " + daysRemaining);
        sc.close();
    }
}