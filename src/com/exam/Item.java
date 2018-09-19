package com.exam;

import java.util.Objects;

/**
 * Represents a part or service that can be sold.
 *
 * care should be taken to ensure that this class is immutable since it
 * is sent to other systems for processing that should not be able to
 * change it in any way.
 *
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Exams are us</p>
 * @author Joe Blow
 * @version 1.0
 */
public class Item implements Comparable<Item>
{
    private final Integer key;
    private final String name;
    private final float price;

    public Item(Integer key, String name, float price)
    {
        this.key = key;
        this.name = name;
        this.price = price;
    }

    public Integer getKey()
    {
        return key;
    }

    public String getName()
    {
        return name;
    }

    public float getPrice()
    {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Float.compare(item.price, price) == 0 &&
                Objects.equals(key, item.key) &&
                Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, price);
    }

    @Override
    public int compareTo(Item item) {
        /* For Ascending order*/
        return this.getName().toLowerCase().compareTo(item.getName().toLowerCase());
    }

}
