package org.example;

public class Roll {
    public static final int TBR = -1;
    public static final Roll RollTBR = new Roll(TBR);

    public static final Roll Strike = new Roll (10);
    private final int value;
    public Roll(String string){
        value = Integer.parseInt(string);
        if (value < TBR || value > 10)
            throw new NumberFormatException("Roll is not valid " + string);
    }
    public Roll(int  in){
        value = in;
        if (value < TBR || value > 10)
            throw new NumberFormatException("Roll is not valid " + in);
    }
    public boolean isTBR(){
        return value == TBR;
    }
    public String toString(){
        return ""+ value;
    }

    public boolean equals(Object obj){
        Roll other = (Roll) obj;
        return this.value == other.value;
    }

    public boolean isStrike() {
        return value == 10;
    }

    public boolean greaterThan(Roll other){
        return (this.value > other.value);
    }

    public boolean greaterThanOrEqual(Roll other){
        return (this.value >= other.value);
    }
    public boolean lessThan(Roll other) {
        return this.value < other.value;
    }

    public boolean lessThanOrEqual(Roll other) {
        return this.value <= other.value;
    }
    public boolean notEqual(Roll other){
        return this.value != other.value;
    }
    public boolean Equal(Roll other){
        return this.value == other.value;
    }
    public Integer toInteger(){
        return Integer.valueOf(value);
    }
    public Roll add(Roll other){
        if (this.value == TBR || other.value == TBR)
            return new Roll(TBR);
        return new Roll(this.value + other.value);
    }
}
