package com.deebeast.behaviorandstate;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class OrderItem {

    private int amount;

    private BigDecimal price;

}
