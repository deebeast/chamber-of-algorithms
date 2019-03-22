package com.diningphilosophers;


class Philosopher {
    private PhilosopherStates state;
    private boolean alreadyInQueue;

    enum PhilosopherStates {
        EATING, HUNGRY, THINKING
    }

    enum Commands {
        EAT, END, EXIT
    }

    Philosopher() {
        this.state = PhilosopherStates.THINKING;
        this.alreadyInQueue = false;
    }

    boolean isAlreadyInQueue() {
        return this.alreadyInQueue;
    }

    void setAlreadyInQueue(boolean alreadyInQueue) {
        this.alreadyInQueue = alreadyInQueue;
    }

    PhilosopherStates getState() {
        return this.state;
    }

    void setState(PhilosopherStates state) {
        this.state = state;
    }
}
