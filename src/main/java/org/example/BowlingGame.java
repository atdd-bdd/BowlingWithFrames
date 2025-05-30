package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowlingGame {
    static final int TBR = -1;
    static final int ROLL_COUNT = 21;
    int[] rolls = new int[ROLL_COUNT];

    int previousFrame = 0;
    int currentFrame = 0;
    public Frame[] frames = {new Frame(), new Frame(), new Frame(), new Frame(), new Frame(),
                             new Frame(), new Frame(), new Frame(), new Frame(), new TenthFrame()};
    public DisplayFrame[] displayFrames  = {new DisplayFrame(), new DisplayFrame(), new DisplayFrame(), new DisplayFrame(), new DisplayFrame(),
            new DisplayFrame(), new DisplayFrame(), new DisplayFrame(), new DisplayFrame(), new DisplayFrame()};

    public BowlingGame() {
        Arrays.fill(rolls, TBR);
    }

    int roll_index = 0;

    public boolean addARoll(int roll) {
        int pinsRemaining = frames[currentFrame].pinsRemaining();
        if (roll >  pinsRemaining || roll < 0)
            return false;
        if (roll_index >= rolls.length)
            return false;
        rolls[roll_index] = roll;
        roll_index++;
        return true;
    }

    public void setRolls(List<Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            rolls[i] = values.get(i);
        }
        roll_index = values.size();
    }

    public List<Integer> getRolls() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < ROLL_COUNT; i++) {
            if (rolls[i] != TBR) result.add(rolls[i]);
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
            if (incrementRoll != BowlingGame.TBR) {
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
