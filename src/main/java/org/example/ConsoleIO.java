package org.example;

public class ConsoleIO {

    public void output(String value) {
        System.out.println(value);
    }

//    void clearScreen() {
//        System.out.print("\033[2J");  // ANSI escape code to clear the screen
//        System.out.print("\033[H");   // Move cursor to the home position
//    }

    Roll getInput(InputControl ic) {
        String statusLine = "Frame " + ic.frameNumber + " Roll " + ic.rollNumber +
                " Pins remaining " + ic.pinsRemaining;

        String prompt = " Roll? ";
        java.io.Console console = System.console();
        if (console == null) {
            System.err.println("NO CONSOLE");
            System.exit(-1);
        }
        console.writer().println(statusLine);
        String input;
        Roll result = Roll.TBR;
        while (result.isTBR()) {
            input = console.readLine(prompt);
            result = checkInput(ic, input);
            if (result.isTBR())
                output("Invalid input " + input);
        }
        return result;
    }

    private Roll checkInput(InputControl ic, String input) {
        try {
            Roll result = new Roll(input);
            if (result.greaterThanOrEqual(Roll.Zero) & result.lessThanOrEqual(new Roll(ic.pinsRemaining)))
                return result;
            return Roll.TBR;
        } catch (NumberFormatException e) {
            Roll result = checkSymbolInput(input, ic);
            if (result.greaterThanOrEqual(Roll.Zero))
                return result;
            return Roll.TBR;
        }
    }

    private Roll checkSymbolInput(String input, InputControl ic) {
        input = input.toUpperCase();
        if (input.equals("-"))
            return Roll.Zero;
        if (ic.rollNumber == 1) {
            if (input.equals("X"))
                return Roll.Strike;
            return Roll.TBR;
        }
        if (ic.rollNumber == 2) {
            if (input.equals("/"))
                return new Roll(ic.pinsRemaining);
            if (ic.frameNumber == 10)
                if (input.equals("X"))
                    return Roll.Strike;
            return Roll.TBR;
        }
        if (ic.rollNumber == 3) {
            if (ic.frameNumber != 10) {
                output("**** Error in model 3 rolls in not 10th frame");
                return Roll.Zero;
            }
            if (input.equals("X"))
                return Roll.Strike;
            return Roll.TBR;
        }
        return Roll.TBR;
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
