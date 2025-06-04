package org.example.original;

public class InputControl {
    public int frameNumber = 0;
    public int rollNumber = 0;
    public int pinsRemaining = -1;

    @Override
    public String toString() {
        return "frameNumber " + frameNumber + " rollNumber " + rollNumber +
                " pinsRemaining " + pinsRemaining;
    }
}
