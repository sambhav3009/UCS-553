import java.util.Objects;
import java.util.Optional;
class Result<T extends Number> {
    private T marks;
    private double threshold;
    Result(T marks, double threshold) {
        this.marks = Objects.requireNonNull(marks);
        this.threshold = threshold;
    }
    double calculatePercentage(double totalMarks) {
        return (marks.doubleValue() / totalMarks) * 100;
    }
    boolean hasPassed() {
        return marks.doubleValue() >= threshold;
    }
    void displayResult() {
        Optional.ofNullable(marks).ifPresent(m -> {
            System.out.println("Marks: " + m);
            System.out.println("Passed: " + hasPassed());
        }); }
}
public class Q3 {
    public static void main(String[] args) {
        Result<Integer> student1 = new Result<>(75, 40);
        System.out.println("Percentage: " +
        student1.calculatePercentage(100));
        student1.displayResult();
    }
}