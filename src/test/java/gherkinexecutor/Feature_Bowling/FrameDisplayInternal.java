package gherkinexecutor.Feature_Bowling;
import java.util.*;
class FrameDisplayInternal{
     String frame;
     String mark1;
     String mark2;
     String mark3;
     String totalScore;
     
    public static String toDataTypeString() {
        return "FrameDisplayInternal {"
        +"String " 
        +"String " 
        +"String " 
        +"String " 
        +"String " 
            + "} "; }  
    FrameDisplay toFrameDisplay() {
        return new FrameDisplay(
        frame
        ,mark1
        ,mark2
        ,mark3
        ,totalScore
        ); }
    public FrameDisplayInternal(
        String frame
        ,String mark1
        ,String mark2
        ,String mark3
        ,String totalScore
        )  {
        this.frame = frame;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.totalScore = totalScore;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameDisplayInternal _FrameDisplayInternal = (FrameDisplayInternal) o;
         return 
                ( _FrameDisplayInternal.frame.equals(this.frame))
                 && ( _FrameDisplayInternal.mark1.equals(this.mark1))
                 && ( _FrameDisplayInternal.mark2.equals(this.mark2))
                 && ( _FrameDisplayInternal.mark3.equals(this.mark3))
                 && ( _FrameDisplayInternal.totalScore.equals(this.totalScore))
             ;  }
        @Override
        public String toString() {
            return "FrameDisplayInternal {"
             +"frame = " + frame + " "
             +"mark1 = " + mark1 + " "
             +"mark2 = " + mark2 + " "
             +"mark3 = " + mark3 + " "
             +"totalScore = " + totalScore + " "
             + "} " + "\n"; }

    }
