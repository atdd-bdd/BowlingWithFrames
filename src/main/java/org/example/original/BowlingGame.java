package org.example.original;

import java.util.Arrays;

public class BowlingGame {
    static final int TBR = -1;
    static final int ROLL_COUNT = 21;
    final int[] rolls = new int[ROLL_COUNT];

    int previousFrame = 0;
    int currentFrame = 0;
    public final Frame[] frames = {new Frame(), new Frame(), new Frame(), new Frame(), new Frame(),
            new Frame(), new Frame(), new Frame(), new Frame(), new TenthFrame()};
    public final DisplayFrame[] displayFrames = {new DisplayFrame(), new DisplayFrame(), new DisplayFrame(), new DisplayFrame(), new DisplayFrame(),
            new DisplayFrame(), new DisplayFrame(), new DisplayFrame(), new DisplayFrame(), new DisplayFrame()};

    public BowlingGame() {
        Arrays.fill(rolls, TBR);
    }

    int roll_index = 0;

    public boolean addARoll(int roll) {
        int pinsRemaining = frames[currentFrame].pinsRemaining();
        if (roll > pinsRemaining || roll < 0)
            return false;
        if (roll_index >= rolls.length)
            return false;
        rolls[roll_index] = roll;
        roll_index++;
        return true;
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
                currentFrame = frameIndex + 1;
                if (currentFrame > frames.length - 1) {
                    System.out.println("Not going to next frame");
                    currentFrame = frames.length - 1;
                }
            } else {
                break;
            }
        }

    }

    public void convertToDisplay() {
        for (int frameIndex = 0; frameIndex < frames.length; frameIndex++) {
            displayFrames[frameIndex] = frames[frameIndex].convertToDisplay();
        }
    }

    public InputControl getInputControl() {
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

    public boolean isNextFrame() {
        if (previousFrame != currentFrame) {
            previousFrame = currentFrame;
            return true;
        }
        return false;
    }
}
