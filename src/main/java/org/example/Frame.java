package org.example;

public class Frame {
    public int roll1 = BowlingGame.TBR;
    public int roll2 = BowlingGame.TBR;
    public int roll3 = BowlingGame.TBR;
    public int frameScore = BowlingGame.TBR;
    public int totalScore = BowlingGame.TBR;

    public String toString() {
        return "roll1 " + roll1 + " roll2 " + roll2 + " roll3 " + roll3 + " frameScore "
                + frameScore + " total score " + totalScore;
    }

    int previousFrameScore;

    int incrementRollIndexForNextFrame(int roll1, int roll2, int roll3, int previousFrameScore) {
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.roll3 = roll3;
        this.previousFrameScore = previousFrameScore;
        scoreFrame();
        return incrementRollIndexBy();
    }

    int getTotalScore() {
        return totalScore;
    }

    private void scoreFrame() {
        if (isStrike()) {
            if (roll3 != BowlingGame.TBR)
                frameScore = roll1 + roll2 + roll3;
        } else if (isSpare()) {
            if (roll3 != BowlingGame.TBR)
                frameScore = roll1 + roll2 + roll3;
        } else if (roll2 != BowlingGame.TBR)
            frameScore = roll1 + roll2;
        if (frameScore != BowlingGame.TBR)
            totalScore = previousFrameScore + frameScore;
    }

    private int incrementRollIndexBy() {
        if (roll1 == BowlingGame.TBR)
            return BowlingGame.TBR;
        if (isStrike())
            return 1;
        if (roll2 == BowlingGame.TBR)
            return BowlingGame.TBR;
        else
            return 2;
    }


    public DisplayFrame convertToDisplay() {
        DisplayFrame displayFrame = new DisplayFrame();
        if (isStrike())
            displayFrame.mark1 = "X";
        else {
            displayFrame.mark1 = markForRoll(roll1);
            if (isSpare())
                displayFrame.mark2 = "/";
            else
                displayFrame.mark2 = markForRoll(roll2);
            }

        if (totalScore != BowlingGame.TBR)
            displayFrame.displayScore = String.format("%3s", String.valueOf(totalScore));
        else
            displayFrame.displayScore = "   ";
        return displayFrame;

    }

    boolean isGameComplete(){
        return false;
    }

    int pinsRemaining(){
        if (roll1 == BowlingGame.TBR)
            return 10 ;
        return 10 - roll1;
    }

    int currentRoll(){
        if (roll1 == BowlingGame.TBR)
            return 1;
        return 2;
    }

    static String markForRoll(int roll) {
        if (roll == 0)
            return "-";
        if (roll != BowlingGame.TBR)
            return String.valueOf(roll);
        return " ";
    }

    boolean isSpare() {
        return roll1 + roll2 == 10;
    }

    boolean isStrike() {
        return roll1 == 10;
    }
}
