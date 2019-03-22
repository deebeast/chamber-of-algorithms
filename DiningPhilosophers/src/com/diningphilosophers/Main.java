package com.diningphilosophers;

//Refer OS by Galvin

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.diningphilosophers.Philosopher.Commands.*;
import static com.diningphilosophers.Philosopher.PhilosopherStates.*;

class Main {
    private static final int numOfPhilosophers = 5;
    private static final Philosopher[] p = new Philosopher[numOfPhilosophers];


    private static void pickup(int i) {
        if (p[i].isAlreadyInQueue()) {
            System.out.println(Philosopher.class.getSimpleName() + " " + i + " Already in queue !");
            return;
        }
        p[i].setState(HUNGRY);
        test(i);
    }

    private static void putdown(int i) {
        if (!EATING.equals(p[i].getState())) {
            System.out.println(Philosopher.class.getSimpleName() + " " + i + " is not Eating.");
            System.out.println(Philosopher.class.getSimpleName() + " " + i + " is in " + p[i].getState() + " state");
            return;
        }
        p[i].setState(THINKING);
        p[i].setAlreadyInQueue(false);
        System.out.println(Philosopher.class.getSimpleName() + " " + i + " has put down forks");
        if (HUNGRY.equals(p[(i + numOfPhilosophers - 1) % numOfPhilosophers].getState()))
            test((i + numOfPhilosophers - 1) % numOfPhilosophers);
        if (HUNGRY.equals(p[(i + 1) % numOfPhilosophers].getState()))
            test((i + 1) % numOfPhilosophers);
    }

    private static void test(int i) {
        if (!EATING.equals(p[(i + numOfPhilosophers - 1) % numOfPhilosophers].getState())
                && HUNGRY.equals(p[i].getState())
                && !(EATING.equals(p[(i + 1) % numOfPhilosophers].getState()))) {
            p[i].setState(EATING);
            p[i].setAlreadyInQueue(true);
            System.out.println(Philosopher.class.getSimpleName() + " " + i + " is eating");
        } else System.out.println(Philosopher.class.getSimpleName() + " " + i + " can't eat at the moment");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < numOfPhilosophers; i++) p[i] = new Philosopher();
        String command;
        String[] temp;
        int philosopherId;
        boolean keepRunning = true;
        while (keepRunning) {
            temp = br.readLine().trim().split(" ");
            command = temp[0];
            if (EXIT.name().equalsIgnoreCase(command))
                keepRunning = false;
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
        }
    }
}
