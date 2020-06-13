package com.deebeast.behaviorandstate;

import javax.json.bind.annotation.JsonbCreator;

public class OrderDto {
    private final Long id;
    private final int number;

    private OrderDto(Long id, int number) {
        this.id = id;
        this.number = number;
    }

    @JsonbCreator
    private static OrderDto of(Long id, int number) {
        return new OrderDto(id, number);
    }

    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

}