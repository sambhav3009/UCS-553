import java.util.Optional;

public class Q2 {
    public static void main(String[] args) {
        Optional<String> email = Optional.of("student@thapar.edu");
        Optional<String> emptyEmail = Optional.empty();
        email.ifPresent(e -> System.out.println("Email: " + e));
        System.out.println("Default Email: " +
                emptyEmail.orElse("default@thapar.edu"));
        try {
            String value = emptyEmail.orElseThrow(
                    () -> new RuntimeException("Email is missing")
            );
            System.out.println(value);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}