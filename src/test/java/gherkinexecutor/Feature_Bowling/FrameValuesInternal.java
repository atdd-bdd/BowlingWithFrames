package gherkinexecutor.Feature_Bowling;
import java.util.*;
class FrameValuesInternal{
     Integer frame;
     Integer roll1;
     Integer roll2;
     Integer roll3;
     Integer score;
     Integer totalScore;
     
    public static String toDataTypeString() {
        return "FrameValuesInternal {"
        +"Integer " 
        +"Integer " 
        +"Integer " 
        +"Integer " 
        +"Integer " 
        +"Integer " 
            + "} "; }  
    FrameValues toFrameValues() {
        return new FrameValues(
        String.valueOf(frame)
        ,String.valueOf(roll1)
        ,String.valueOf(roll2)
        ,String.valueOf(roll3)
        ,String.valueOf(score)
        ,String.valueOf(totalScore)
        ); }
    public FrameValuesInternal(
        Integer frame
        ,Integer roll1
        ,Integer roll2
        ,Integer roll3
        ,Integer score
        ,Integer totalScore
        )  {
        this.frame = frame;
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.roll3 = roll3;
        this.score = score;
        this.totalScore = totalScore;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameValuesInternal _FrameValuesInternal = (FrameValuesInternal) o;
         return 
                ( _FrameValuesInternal.frame.equals(this.frame))
                 && ( _FrameValuesInternal.roll1.equals(this.roll1))
                 && ( _FrameValuesInternal.roll2.equals(this.roll2))
                 && ( _FrameValuesInternal.roll3.equals(this.roll3))
                 && ( _FrameValuesInternal.score.equals(this.score))
                 && ( _FrameValuesInternal.totalScore.equals(this.totalScore))
             ;  }
        @Override
        public String toString() {
            return "FrameValuesInternal {"
             +"frame = " + frame + " "
             +"roll1 = " + roll1 + " "
             +"roll2 = " + roll2 + " "
             +"roll3 = " + roll3 + " "
             +"score = " + score + " "
             +"totalScore = " + totalScore + " "
             + "} " + "\n"; }

    }
