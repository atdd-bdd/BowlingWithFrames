package org.example;

public class Main {
    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        BowlingGame game = new BowlingGame();
        while (true){
//            io.clearScreen();    // Does not work

            game.computeScore();

            String s  = io.createOutput(game.convertToDisplay());
            io.output(s);
            io.output("");
            if (game.isNextFrame())
                io.output("New frame");
            if (game.isComplete()) {
                io.output("Game Over");
                break;
            }
            InputControl ic = game.getInputControl();
            Roll input = io.getInput( ic);
            if (!game.addARoll(input))
                io.output("Input check failed");
            io.output("");
        }
    }
}
