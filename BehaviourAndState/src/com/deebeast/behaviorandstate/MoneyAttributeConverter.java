package com.deebeast.behaviorandstate;

import java.math.BigDecimal;

import javax.persistence.AttributeConverter;

/**
 * MoneyAttributeConverter
 */
public class MoneyAttributeConverter implements AttributeConverter<Money, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(Money arg0) {
        return null;
    }

    @Override
    public Money convertToEntityAttribute(BigDecimal arg0) {
        return null;
    }

}