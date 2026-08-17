package food.model;

public abstract class FoodOrder {
    private int orderId;
    private String customerName;
    private double amount;
    private static String restaurantName = "Melodrama";
    private static int orderCount = 0;
    public FoodOrder(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        orderCount++;
    }
    public abstract double calculateDeliveryCharge();

    public int getOrderId() {
        return orderId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getAmount() {
        return amount;
    }
    public static String getRestaurantName() {
        return restaurantName;
    }
    public static int getOrderCount() {
        return orderCount;
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
  
    public static void displayTotalOrders() {
        System.out.println("Total Orders: " + orderCount);
    }
}