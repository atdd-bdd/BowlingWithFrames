package org.example;

public class TenthFrame extends Frame {
    public DisplayFrame convertToDisplay() {
        DisplayFrame displayFrame = new DisplayFrame();
        if (isStrike())
            displayFrame.mark1 = "X";
        else {
            displayFrame.mark1 = markForRoll(roll1);
        }
        if (isSpare())
            displayFrame.mark2 = "/";
        else {
            if (roll2.isStrike())
                displayFrame.mark2 = "X";
            else
                displayFrame.mark2 = markForRoll(roll2);
        }
        if (roll3.isStrike())
            displayFrame.mark3 = "X";
        else
            displayFrame.mark3 = markForRoll(roll3);

        if (totalScore != BowlingGame.TBS)
            displayFrame.displayScore = String.format("%3s", totalScore);
        else
            displayFrame.displayScore = "   ";
        return displayFrame;

    }

    boolean isGameComplete() {
        if (roll2.isTBR() )
            return false;
        if (isStrike() || isSpare())
            //noinspection RedundantIfStatement
            if (roll3.isTBR())
                return false;
        return true;
    }

    int pinsRemaining() {
        if (roll1.isTBR())
            return Frame.PINS_IN_FRAME;
        if (isStrike()) {
            if (roll2.isTBR())
                return Frame.PINS_IN_FRAME;
            if (roll2.isStrike())
                return Frame.PINS_IN_FRAME;
            return Frame.PINS_IN_FRAME - roll2.toInteger();
        }
        if (roll2.isNotTBR())
            if (isSpare())
                return Frame.PINS_IN_FRAME;
        return Frame.PINS_IN_FRAME-roll1.toInteger();
    }

    int currentRoll() {
        if (roll1.isTBR())
            return 1;
        if (roll2.isTBR())
            return 2;
        return 3;
    }
}
