package com.deebeast.behaviorandstate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;
/**
 * everything we do here is centrally making sure the state of the object
 */
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private int number;

    public List<OrderItem> items = Lists.mutable.empty();

    public int getNumber() {
        return number;
    }

    public ImmutableList<OrderItem> getItems() {
        return Lists.immutable.ofAll(items);
    }
    public Order addItem(OrderItem item) {
        Preconditions.checkArgument(item!=null);
        items.add(item);
        return this;
    }

}