package com.exam;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Represents and Order that contains a collection of items.
 *
 * care should be taken to ensure that this class is immutable since it
 * is sent to other systems for processing that should not be able
 * to change it in any way.
 *
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Exams are us</p>
 * @author Joe Blow
 * @version 1.0
 */
public final class Order implements Serializable
{
    private final OrderItem[] orderItems;

    public Order(OrderItem[] orderItems)
    {
        this.orderItems = orderItems;
    }

    // Returns the total order cost after the tax has been applied
    public float getOrderTotal(float taxRate)
    {
        float price = 0;
        for( OrderItem item : this.orderItems) {
            if( item instanceof MaterialOrderItem) {
                price += ((MaterialOrderItem) item).getItemTotal(taxRate);
            } else {
                price += ((ServiceOrderItem) item).getItemTotal();
            }
        }

        // Got the total price, now format it.
        DecimalFormat df = new DecimalFormat("####.##");

        try {
            price = Float.parseFloat(df.format(price));
        } catch (NumberFormatException e) {
            System.out.println(" Parse Error::" + e.getMessage());
        }

        return price;
    }

    /**
     * Returns a Collection of all items sorted by item name
     * (case-insensitive).
     *
     * @return Collection
     */
    public Collection<OrderItem> getItems()
    {
        // Cloning so that we keep this class immutable
        ArrayList<OrderItem> list = new ArrayList<OrderItem>(Arrays.asList(orderItems));

        Collections.sort(list);

        return list;
    }


}