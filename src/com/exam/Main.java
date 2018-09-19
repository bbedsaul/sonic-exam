package com.exam;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final float TAXRATE = .0845f;
        OrderItem[] orders = new OrderItem[10];

        try {
            // Make 10 orders to test
            orders[0] = new MaterialOrderItem( new Integer(1), "soda", 1.29f, 1 );
            orders[1] = new MaterialOrderItem( new Integer(2), "french fries", 1.99f, 3 );
            orders[2] = new MaterialOrderItem( new Integer(3), "corn dog", 1.19f, 1 );
            orders[3] = new MaterialOrderItem( new Integer(4), "jalepeno popper", 3.29f, 7 );
            orders[4] = new MaterialOrderItem( new Integer(5), "shake", 3.99f, 2 );
            orders[5] = new ServiceOrderItem( new Integer(6), "sundae", 1.09f, 5 );
            orders[6] = new ServiceOrderItem( new Integer(7), "double cheeseburger", 3.99f, 1 );
            orders[7] = new ServiceOrderItem( new Integer(8), "bacon cheeseburger", 2.99f, 2 );
            orders[8] = new ServiceOrderItem( new Integer(9), "chicken sandwich", 3.49f, 1 );
            orders[9] = new ServiceOrderItem( new Integer(10), "Cheeseburger", 2.49f, 3 );

            Order order = new Order(orders);

            // Print order total
            System.out.println("Order Total :: " + order.getOrderTotal(TAXRATE));

            Collection<OrderItem> testItems = order.getItems();
            for (OrderItem orderItem : order.getItems()) {
                System.out.println("Order " + orderItem.getKey() + " Name :: " + orderItem.getName() + " Price :: " + orderItem.getPrice());
            }

            // Add Items to a hashtable
            Hashtable table = new Hashtable<Item, Item>();
            for (OrderItem orderItem : order.getItems()) {
                table.put(orderItem, orderItem);
            }

            // Good enough to see it worked.
            System.out.println("Created Hashtable :: " + table.toString());

            // Serialization Test
            try {
                FileOutputStream fileOut =
                        new FileOutputStream("/tmp/order.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(order);
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in /tmp/order.ser");
            } catch (IOException i) {
                i.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("Exception in Program ::" + e.getMessage());
        }

    }
}
