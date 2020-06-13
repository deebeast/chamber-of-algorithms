package com.deebeast.behaviorandstate;

import java.math.BigDecimal;

/**
 * Money
 */
public class Money {
    final BigDecimal value;

    private Money(BigDecimal value) {
        this.value = value;
    }

}