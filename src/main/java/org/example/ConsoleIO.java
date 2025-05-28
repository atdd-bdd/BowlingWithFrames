package org.example;

public class ConsoleIO {
    void clearScreen(){
        System.out.print("\033[2J");  // ANSI escape code to clear the screen
        System.out.print("\033[H");   // Move cursor to the home position
    }
    String getInput(String prompt){
        java.io.Console console = System.console();
        String input = "";
        if (console != null) {
            input = console.readLine(prompt);
            System.out.println("You entered: " + input);
        } else {
            System.out.println("Console is not available.");
        }
        return input;
    }
}
