public class Q1 {
    public static <T extends Number> double sum(T[] arr) {
        double total = 0;

        for (T num : arr) {
            total += num.doubleValue();
        }
        return total;
    }
    public static void main(String[] args) {
        Integer[] integers = {10, 20, 30};
        Float[] floats = {1.5f, 2.5f, 3.5f};
        Double[] doubles = {1.1, 2.2, 3.3};

        System.out.println("Sum of Integers: " + sum(integers));
        System.out.println("Sum of Floats: " + sum(floats));
        System.out.println("Sum of Doubles: " + sum(doubles));
    }
}