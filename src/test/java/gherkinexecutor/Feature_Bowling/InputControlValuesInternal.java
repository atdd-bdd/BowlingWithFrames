package gherkinexecutor.Feature_Bowling;
import java.util.*;
import org.example.*;
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
class InputControlValuesInternal{
     final Integer frame;
     final Integer roll;
     final Integer remaining;
     
    public static String toDataTypeString() {
        return "InputControlValuesInternal {"
        +"Integer " 
        +"Integer " 
        +"Integer " 
            + "} "; }  
    InputControlValues toInputControlValues() {
        return new InputControlValues(
        String.valueOf(frame)
        ,String.valueOf(roll)
        ,String.valueOf(remaining)
        ); }
    public InputControlValuesInternal(
        Integer frame
        ,Integer roll
        ,Integer remaining
        )  {
        this.frame = frame;
        this.roll = roll;
        this.remaining = remaining;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputControlValuesInternal _InputControlValuesInternal = (InputControlValuesInternal) o;
         return 
                ( _InputControlValuesInternal.frame.equals(this.frame))
                 && ( _InputControlValuesInternal.roll.equals(this.roll))
                 && ( _InputControlValuesInternal.remaining.equals(this.remaining))
             ;  }
        @Override
        public String toString() {
            return "InputControlValuesInternal {"
             +"frame = " + frame + " "
             +"roll = " + roll + " "
             +"remaining = " + remaining + " "
             + "} " + "\n"; }

    }
