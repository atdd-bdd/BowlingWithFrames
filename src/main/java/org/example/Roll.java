package org.example;

public class Roll {
    static final int TBR_VALUE = -1;
    public static final Roll TBR = new Roll(TBR_VALUE);
    public static final Roll Zero = new Roll(0);

    public static final Roll Strike = new Roll (10);
    private final int value;
    public Roll(String string){
        value = Integer.parseInt(string);
        if (value < TBR_VALUE || value > 10)
            throw new NumberFormatException("Roll is not valid " + string);
    }
    public Roll(int  in){
        value = in;
        if (value < TBR_VALUE || value > 10)
            throw new NumberFormatException("Roll is not valid " + in);
    }
    public boolean isTBR(){
        return value == TBR_VALUE;
    }

    public boolean isNotTBR(){
        return value != TBR_VALUE;
    }
    public String toString(){
        return ""+ value;
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
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

    public boolean equal(Roll other){
        return this.value == other.value;
    }
    public Integer toInteger(){
        return value;
    }

}
