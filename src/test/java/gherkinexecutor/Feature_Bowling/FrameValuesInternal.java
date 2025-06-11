package gherkinexecutor.Feature_Bowling;
import java.util.*;
import org.example.*;
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
class FrameValuesInternal{
     final Integer frame;
     final Roll roll1;
     final Roll roll2;
     final Roll roll3;
     final Score score;
     final Score totalScore;
     
    public static String toDataTypeString() {
        return "FrameValuesInternal {"
        +"Integer " 
        +"Roll " 
        +"Roll " 
        +"Roll " 
        +"Score " 
        +"Score " 
            + "} "; }  
    FrameValues toFrameValues() {
        return new FrameValues(
        String.valueOf(frame)
        ,roll1.toString()
        ,roll2.toString()
        ,roll3.toString()
        ,score.toString()
        ,totalScore.toString()
        ); }
    public FrameValuesInternal(
        Integer frame
        ,Roll roll1
        ,Roll roll2
        ,Roll roll3
        ,Score score
        ,Score totalScore
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
