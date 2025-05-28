package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowlingGame {
    static final int TBR = -1;
    static final int ROLL_COUNT = 20;
    int[] rolls = new int[ROLL_COUNT];

    Frame[] frames = {new Frame(), new Frame(), new Frame(), new Frame(), new Frame(), new Frame(), new Frame(), new Frame()};

    static int IR = ROLL_COUNT - 4;
    int[] startingRollForFrame = {0, IR, IR, IR, IR, IR, IR, IR, IR, IR};

    public BowlingGame() {
        Arrays.fill(rolls, TBR);
    }

    int roll_index = 0;

    public void addARole(int roll) {
        rolls[roll_index] = roll;
        roll_index++;
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
        int frameIndex = 0;
        for (int index = 0; index < ROLL_COUNT; index++) {
            Frame frame = frames[frameIndex];
            int start = startingRollForFrame[frameIndex];
            boolean isFrameComplete = frame.isFrameCompleteAfterRolls(rolls[start], rolls[start + 1], rolls[start + 3], previousFrameScore);
            if (isFrameComplete) {
                previousFrameScore = frame.getTotalScore();
                frameIndex++;
                if (frameIndex > frames.length - 1) {
                    System.err.println("Beyond end of frames");
                    break;
                }
                startingRollForFrame[frameIndex] = index;
            }
        }

    }
}
