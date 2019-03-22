package com.diningphilosophers;

//Refer OS by Galvin

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        PhilosopherUtils philosopherUtils = new PhilosopherUtils();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        boolean keepRunning = true;
        while (keepRunning) {
            input = br.readLine().trim().split(" ");
            keepRunning = philosopherUtils.processCommand(input);
        }
    }

}
