package com.deebeast.behaviorandstate;

public class Preconditions {

    private Preconditions() {
    }

    public static void checkArgument(boolean argument) {
        if (!argument) {
            throw new IllegalArgumentException("Illegal Argument");
        }
    }

}