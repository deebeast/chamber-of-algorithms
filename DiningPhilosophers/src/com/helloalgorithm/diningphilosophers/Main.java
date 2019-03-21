package com.helloalgorithm.diningphilosophers;

//Refer OS by Galvin

import com.helloalgorithm.diningphilosophers.PhilosopherState.PhilosopherStates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static Philosopher[] p = new Philosopher[5];
    private static int max = 5;

    private static void pickup(int i) {
        if (p[i].isAlreadyInQueue()) {
            System.out.println("p[" + i + "] Already in queue !");
            return;
        }
        p[i].setState(PhilosopherStates.HUNGRY);
        test(i);
    }

    private static void putsdown(int i) {
        if (!PhilosopherStates.EATING.equals(p[i].getState())) {
            System.out.println("p[" + i + "] is not Eating.");
            System.out.println("p[" + i + "] is in " + p[i].getState() + " state");
            return;
        }
        p[i].setState(PhilosopherStates.THINKING);
        p[i].setAlreadyInQueue(false);
        System.out.println("p[" + i + "] has put down forks");
        if (PhilosopherStates.HUNGRY.equals(p[(i + 4) % 5].getState())) test((i + 4) % 5);
        if (PhilosopherStates.HUNGRY.equals(p[(i + 1) % 5].getState())) test((i + 1) % 5);
    }

    private static void test(int i) {
        if (!PhilosopherStates.EATING.equals(p[(i + 4) % 5].getState()) && PhilosopherStates.HUNGRY.equals(p[i].getState()) && !(PhilosopherStates.EATING.equals(p[(i + 1) % 5].getState()))) {
            p[i].setState(PhilosopherStates.EATING);
            p[i].setAlreadyInQueue(true);
            System.out.println("p[" + i + "] is eating");
        } else System.out.println("p[" + i + "] can't eat at the moment");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("-------------------------");
        System.out.println("The program has started..");
        System.out.println("-------------------------");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) p[i] = new Philosopher();
        String command;
        String[] temp;
        int pid;
        while (true) {
            temp = br.readLine().trim().split(" ");
            command = temp[0];
            pid = Integer.parseInt(temp[1]);
            if (pid < max) {
                if (command.equals("eat")) pickup(pid);
                else if (command.equals("end")) putsdown(pid);
            } else System.out.println("philosopher not present");
        }
    }
}
