package com.diningphilosophers;

import static com.diningphilosophers.Philosopher.Commands.*;
import static com.diningphilosophers.Philosopher.PhilosopherStates.*;

class PhilosopherUtils {
    PhilosopherUtils() {
        this.numOfPhilosophers = 5;
        this.philosophers = new Philosopher[numOfPhilosophers];
        for (int i = 0; i < numOfPhilosophers; i++) philosophers[i] = new Philosopher();
    }

    private int numOfPhilosophers;
    private Philosopher[] philosophers;

    private void pickup(int i) {
        if (philosophers[i].isAlreadyInQueue()) {
            System.out.println(Philosopher.class.getSimpleName() + " " + i + " Already in queue !");
            return;
        }
        philosophers[i].setState(HUNGRY);
        test(i);
    }

    private void putdown(int i) {
        if (!EATING.equals(philosophers[i].getState())) {
            System.out.println(Philosopher.class.getSimpleName() + " " + i + " is not Eating.");
            System.out.println(Philosopher.class.getSimpleName() + " " + i + " is in " + philosophers[i].getState() + " state");
            return;
        }
        philosophers[i].setState(THINKING);
        philosophers[i].setAlreadyInQueue(false);
        System.out.println(Philosopher.class.getSimpleName() + " " + i + " has put down forks");
        if (HUNGRY.equals(philosophers[(i + numOfPhilosophers - 1) % numOfPhilosophers].getState()))
            test((i + numOfPhilosophers - 1) % numOfPhilosophers);
        if (HUNGRY.equals(philosophers[(i + 1) % numOfPhilosophers].getState()))
            test((i + 1) % numOfPhilosophers);
    }

    private void test(int i) {
        if (!EATING.equals(philosophers[(i + numOfPhilosophers - 1) % numOfPhilosophers].getState())
                && HUNGRY.equals(philosophers[i].getState())
                && !(EATING.equals(philosophers[(i + 1) % numOfPhilosophers].getState()))) {
            philosophers[i].setState(EATING);
            philosophers[i].setAlreadyInQueue(true);
            System.out.println(Philosopher.class.getSimpleName() + " " + i + " is eating");
        } else {
            System.out.println(Philosopher.class.getSimpleName() + " " + i + " can't eat at the moment");
            System.out.println(Philosopher.class.getSimpleName() + " " + i + " is in " + philosophers[i].getState() + " state");
        }
    }

    boolean processCommand(String[] temp) {
        String command = temp[0];
        int philosopherId;
        if (EXIT.name().equalsIgnoreCase(command))
            return false;
        else {
            philosopherId = Integer.parseInt(temp[1]);
            if (philosopherId < numOfPhilosophers) {
                if (EAT.name().equalsIgnoreCase(command)) {
                    pickup(philosopherId);
                } else if (END.name().equalsIgnoreCase(command)) {
                    putdown(philosopherId);
                }
            } else {
                System.out.println(Philosopher.class.getSimpleName() + " " + philosopherId + " not present");
            }
        }
        return true;
    }

}
