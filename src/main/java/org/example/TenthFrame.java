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
            if (roll2 == 10)
                displayFrame.mark2 = "X";
            else
                displayFrame.mark2 = markForRoll(roll2);
        }
        if (roll3 == 10)
            displayFrame.mark3 = "X";
        else
            displayFrame.mark3 = markForRoll(roll3);

        if(totalScore !=BowlingGame.TBR)
    displayFrame.displayScore =String.format("%3s",String.valueOf(totalScore));
        else
    displayFrame.displayScore ="   ";
        return displayFrame;

}
    boolean isGameComplete() {
        if (roll2 == BowlingGame.TBR)
            return false;
        if (isStrike() || isSpare())
            if (roll3 == BowlingGame.TBR)
                return false;
        return true;
    }
    int pinsRemaining(){
        if (roll1 == BowlingGame.TBR)
            return 10;
        if (isStrike()) {
            if (roll2 == BowlingGame.TBR)
                return 10;
            if (roll2 == 10)
                return 10;
            return 10 - roll2;
        }
        if (roll2 == BowlingGame.TBR)
            return 10 - roll1;
        if (isSpare())
            return 10;
        return 0;
    }
    int currentRoll(){
        if (roll1 == BowlingGame.TBR)
            return 1;
        if (roll2 == BowlingGame.TBR)
            return 2;
        return 3;
    }
}
