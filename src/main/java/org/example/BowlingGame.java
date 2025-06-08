package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowlingGame {
    static final int TBS = -1;
    static final int ROLL_COUNT = 21;
    final Roll[] rolls = new Roll[ROLL_COUNT];

    int previousFrame = 0;
    int currentFrame = 0;
    public final Frame[] frames = {new Frame(), new Frame(), new Frame(), new Frame(), new Frame(),
                             new Frame(), new Frame(), new Frame(), new Frame(), new TenthFrame()};
    public final DisplayFrame[] displayFrames  = {new DisplayFrame(), new DisplayFrame(), new DisplayFrame(), new DisplayFrame(), new DisplayFrame(),
            new DisplayFrame(), new DisplayFrame(), new DisplayFrame(), new DisplayFrame(), new DisplayFrame()};

    public BowlingGame() {
        Arrays.fill(rolls, Roll.TBR);
    }

    int roll_index = 0;

    public boolean addARoll(Roll roll) {
        int pinsRemaining = frames[currentFrame].pinsRemaining();
        if (roll.greaterThan(new Roll(pinsRemaining))|| roll.lessThan(Roll.Zero))
            return false;
        if (roll_index >= rolls.length)
            return false;
        rolls[roll_index] = roll;
        roll_index++;
        return true;
    }

    public List<Integer> getRolls() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < ROLL_COUNT; i++) {
            if (rolls[i].isNotTBR())
                result.add(rolls[i].toInteger()) ;
        }
        return result;
    }

    public void computeScore() {
        int previousFrameScore = 0;
        int start = 0;
        for (int frameIndex = 0; frameIndex < frames.length; frameIndex++) {
            Frame frame = frames[frameIndex];
            int incrementRoll =
                    frame.incrementRollIndexForNextFrame(rolls[start], rolls[start + 1], rolls[start + 2], previousFrameScore);
            if (incrementRoll != 0) {
                previousFrameScore = frame.getTotalScore();
                start += incrementRoll;
                currentFrame = frameIndex+1;
                if (currentFrame > frames.length - 1)
                    currentFrame = frames.length - 1;
            }
            else {
                break;
            }
        }

    }
    public void convertToDisplay() {
        for (int frameIndex = 0; frameIndex < frames.length; frameIndex++) {
            displayFrames[frameIndex] = frames[frameIndex].convertToDisplay();
        }
    }

    public InputControl getInputControl()
    {
        InputControl ic = new InputControl();
        ic.frameNumber = currentFrame + 1;
        Frame cf = frames[currentFrame];
        ic.rollNumber = cf.currentRoll();
        ic.pinsRemaining = cf.pinsRemaining();
        return ic;
    }
    public boolean isComplete() {
        return frames[frames.length - 1].isGameComplete();
    }
    public boolean isNextFrame(){
        if (previousFrame!=currentFrame)
        {
            previousFrame = currentFrame;
            return true;
        }
        return false;
    }
}
