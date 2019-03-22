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
        state = PhilosopherStates.THINKING;
        alreadyInQueue = false;
    }

    boolean isAlreadyInQueue() {
        return alreadyInQueue;
    }

    void setAlreadyInQueue(boolean alreadyInQueue) {
        this.alreadyInQueue = alreadyInQueue;
    }

    PhilosopherStates getState() {
        return state;
    }

    void setState(PhilosopherStates state) {
        this.state = state;
    }
}
