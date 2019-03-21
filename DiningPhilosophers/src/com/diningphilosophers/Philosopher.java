package com.diningphilosophers;

import com.diningphilosophers.PhilosopherState.PhilosopherStates;

class Philosopher {
    private PhilosopherStates state;
    private boolean alreadyInQueue;

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