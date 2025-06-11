package org.example;

public class Frame {
    public Roll roll1 = Roll.TBR;
    public Roll roll2 = Roll.TBR;
    public Roll roll3 = Roll.TBR;
    public Score frameScore = Score.TBS;
    public Score totalScore = Score.TBS;
    public static final int PINS_IN_FRAME = 10;

    public String toString() {
        return "roll1 " + roll1 + " roll2 " + roll2 + " roll3 " + roll3 + " frameScore "
                + frameScore + " total score " + totalScore;
    }

    Score previousFrameScore;

    int incrementRollIndexForNextFrame(Roll roll1, Roll roll2, Roll roll3, Score previousFrameScore) {
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.roll3 = roll3;
        this.previousFrameScore = previousFrameScore;
        scoreFrame();
        return incrementRollIndexBy();
    }

    Score getTotalScore() {
        return totalScore;
    }

    private void scoreFrame() {
        if (isStrike() || isSpare())
             frameScore = Score.addRolls(roll1, roll2, roll3);
         else
            frameScore = Score.addRolls(roll1, roll2);
         totalScore = Score.addScores(previousFrameScore ,frameScore);
    }

    private int incrementRollIndexBy() {
        if (roll1.isTBR())
            return 0;
        if (isStrike())
            return 1;
        if (roll2.isTBR())
            return 0;
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
        displayFrame.displayScore = totalScore.toString();
        return displayFrame;

    }

    boolean isGameComplete(){
        return false;
    }

    int pinsRemaining(){
        if (roll1.isTBR())
            return PINS_IN_FRAME ;
        return PINS_IN_FRAME - roll1.toInteger();
    }

    int currentRoll(){
        if (roll1.isTBR())
            return 1;
        return 2;
    }

    static String markForRoll(Roll roll) {
        if (roll.equal(Roll.Zero) )
            return "-";
        if (roll.isNotTBR())
            return String.valueOf(roll);
        return " ";
    }

    boolean isSpare() {
        return roll1.toInteger() +
                roll2.toInteger() == PINS_IN_FRAME;
    }

    boolean isStrike() {
        return roll1.isStrike();
    }
}
