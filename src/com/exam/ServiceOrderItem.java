package com.exam;

/**
 * Represents an OrderItem.
 *
 * care should be taken to ensure that this class is immutable since it
 * is sent to other systems for processing that should not be able
 * to change it in any way.
 *
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Exams are us</p>
 * @author Bill Bedsaul
 * @version 1.0
 */
import java.io.Serializable;

public final class ServiceOrderItem extends OrderItem implements Serializable {

    public ServiceOrderItem(Integer key, String name, float price, int quantity)
    {
        super(key, name, price, quantity);
    }

    public float getItemTotal() {

        return this.getPrice() * this.getQuantity();
    }
}
