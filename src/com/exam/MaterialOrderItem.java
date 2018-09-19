package com.exam;

import java.io.Serializable;

/**
 * Represents an OrderItem.
 *
 * Extends the OrderItem for taxable items.
 *
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Exams are us</p>
 * @author Bill Bedsaul
 * @version 1.0
 */
public final class MaterialOrderItem extends OrderItem implements Serializable {

    public MaterialOrderItem(Integer key, String name, float price, int quantity)
    {
        super(key, name, price, quantity);
    }

    public float getItemTotal(float taxRate) {

        return this.getPrice() * this.getQuantity() * (1 + taxRate);
    }
}
