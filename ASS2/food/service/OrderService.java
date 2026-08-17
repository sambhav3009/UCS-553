package food.service;
import food.model.FoodOrder;
import food.utility.OrderUtility;
public class OrderService {
    public static void displayBills(FoodOrder[] orders) {
        for(FoodOrder order : orders) {
            if(order!=null) {
                if(OrderUtility.validateAmount(order.getAmount())
                        && OrderUtility.validateCustomerName(order.getCustomerName())) {
                    OrderUtility.generateSummary(order);
                }else {
                    System.out.println("Invalid order details for Order ID: "
                            + order.getOrderId());
                
            }
        }
    }
}
}