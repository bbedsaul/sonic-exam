package com.exam;

import java.io.Serializable;

/**
 * Represents an OrderItem.
 *
 * extends OrderItem to include a quantity.
 *
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Exams are us</p>
 * @author Bill Bedsaul
 * @version 1.0
 */
public class OrderItem extends Item implements Serializable {

    public final int quantity;

    public OrderItem(Integer key, String name, float price, int quantity)
    {
        super(key, name, price);
        this.quantity = quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

}
