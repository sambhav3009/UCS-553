import java.util.Objects;
import java.util.Optional;
class Utility<T> {
    public boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }
    public T getDefault(Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }
    public <U extends Comparable<U>> U max(U a, U b) {
        return a.compareTo(b) >= 0 ? a : b;
    }
    public boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}
public class Q5 {
    public static void main(String[] args) {
        Utility<String> stringUtility = new Utility<>();
        System.out.println("Equal Strings: " +
                stringUtility.isEqual("Java", "Java"));
        System.out.println("Default Value: " +
                stringUtility.getDefault(Optional.empty(), "Default"));
        System.out.println("Maximum String: " +
                stringUtility.max("Apple", "Mango"));
        System.out.println("Is Null: " +
                stringUtility.isNull(null));
        Utility<Integer> integerUtility = new Utility<>();
        System.out.println("Equal Integers: " +
                integerUtility.isEqual(10, 10));
        System.out.println("Maximum Integer: " +
                integerUtility.max(20, 30));
        System.out.println("Default Integer: " +
                integerUtility.getDefault(Optional.of(50), 0));
        System.out.println("Is Null: " +
                integerUtility.isNull(100));
    }
}