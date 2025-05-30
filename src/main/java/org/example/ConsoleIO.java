package org.example;

public class ConsoleIO {

    public void output(String value) {
        System.out.println(value);
    }

    void clearScreen() {
        System.out.print("\033[2J");  // ANSI escape code to clear the screen
        System.out.print("\033[H");   // Move cursor to the home position
    }

    int getInput(InputControl ic) {
        String statusLine = "Frame " + ic.frameNumber + " Roll " + ic.rollNumber +
            " Pins remaining " + ic.pinsRemaining;

        String prompt =  " Roll? ";
        java.io.Console console = System.console();
        if (console == null) {
            System.err.println("NO CONSOLE");
            System.exit(-1);
        }
        console.writer().println(statusLine);
        String input;
        int result = -1;
        boolean valid = false;
        while (!valid) {
            input = console.readLine(prompt);
            try {
                result = Integer.parseInt(input);
                if (result >= 0 && result <= ic.pinsRemaining)
                    valid = true;
            } catch (NumberFormatException e) {
                result = checkSymbolInput(input, ic);
                if (result >= 0)
                    valid = true;
            }
            if (!valid)
                System.out.println("Invalid input " + input);
        }
        return result;
    }

    private int checkSymbolInput(String input, InputControl ic) {
        if (input.equals("-"))
            return 0;
        if (ic.rollNumber == 1){
              if (input.equals("X"))
                return 10;
            return -1;
        }
        if (ic.rollNumber == 2) {
            if (input.equals("/"))
                return ic.pinsRemaining;
            if (ic.frameNumber == 10)
                if (input.equals("X"))
                    return 10;
            return -1;
        }
        if (ic.rollNumber == 3) {
            if (ic.frameNumber != 10) {
                System.out.println("**** Error in model 3 rolls in not 10th frame");
                return 0;
            }
            if (input.equals("X"))
                return 10;
            return -1;
        }
        return -1;
    }

    public String createOutput(DisplayFrame[] frames) {

        StringBuilder output = new StringBuilder();
        output.append("|");
        for (DisplayFrame frame : frames) {
            String part = frame.mark1 + frame.mark2 + frame.mark3 + "|";
            output.append(part);
        }
        output.append("\n|");
        for (DisplayFrame frame : frames) {
            String part = frame.displayScore + "|";
            output.append(part);
        }
        output.append("\n");
        return output.toString();
    }
}
