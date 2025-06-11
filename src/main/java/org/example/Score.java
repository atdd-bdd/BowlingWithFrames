package org.example;

public class Score {
    private static int TBS_VALUE = -1;
    public static Score TBS = new Score(TBS_VALUE);
    private int value = TBS_VALUE;
    public Score(int value){
        this.value = value;
    }

    public String toString(){
        if (value == TBS_VALUE)
            return "   ";
        return String.format("%3s", value);
    }
    public static Score addScores(Score one, Score two){
        if (one.value == TBS_VALUE || two.value == TBS_VALUE)
            return Score.TBS;
        return new Score(one.value + two.value);
    }
    public static Score addRolls(Roll roll1, Roll roll2){
        if (roll1.isTBR() || roll2.isTBR())
            return Score.TBS;
        return new Score(roll1.toInteger() + roll2.toInteger());

    }
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Score other = (Score) obj;
        return this.value == other.value;
    }
    public static Score addRolls(Roll roll1, Roll roll2, Roll roll3 ){
        if (roll1.isTBR() || roll2.isTBR() || roll3.isTBR())
            return Score.TBS;
        return new Score(roll1.toInteger() + roll2.toInteger() + roll3.toInteger());
    }
}
