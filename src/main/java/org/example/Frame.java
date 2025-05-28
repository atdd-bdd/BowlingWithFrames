package org.example;

public class Frame {
    int roll1;
    int roll2;
    int roll3;
    int frameScore = BowlingGame.TBR;
    int totalScore = BowlingGame.TBR;

    int previousFrameScore;
    boolean isFrameCompleteAfterRolls(int roll1, int roll2, int roll3, int previousFrameScore){
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.roll3 = roll3;
        this.previousFrameScore = previousFrameScore;
        scoreFrame();
        return goToNextFrame();
    }

    int getTotalScore(){
        return totalScore;
    }
    private void scoreFrame() {
        if (roll1 == 10){
            if (roll3 == BowlingGame.TBR)
                return;
            else
                frameScore = roll1 + roll2 + roll3;
        }
        else {if (roll2 == BowlingGame.TBR) {
            return;
        }
        else if (roll1 + roll2 == 10)
            frameScore = roll1 + roll2 + roll3;
            else
                frameScore = roll1 + roll2;
        }
        if (previousFrameScore == BowlingGame.TBR)
            return;
        totalScore = previousFrameScore + frameScore;
    }

    private boolean goToNextFrame() {
        if (roll1 == BowlingGame.TBR)
            return false;
        if (roll1 == 10) {
            return true;
        }
        if (roll2 == BowlingGame.TBR)
            return false;
        return true;
    }


}
