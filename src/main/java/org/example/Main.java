package org.example;

public class Main {
    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        while (true){
            io.clearScreen();
            String input = io.getInput("What? ");
            if (input.equals(""))
                break;
        }
    }
}
