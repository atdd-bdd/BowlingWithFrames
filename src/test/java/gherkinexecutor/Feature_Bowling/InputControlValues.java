package gherkinexecutor.Feature_Bowling;
import java.util.*;
import org.example.*;
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
class InputControlValues{
    String frame = "1";
    String roll = "1";
    String remaining = "10";
    public InputControlValues() { }
    public InputControlValues(
        String frame
        ,String roll
        ,String remaining
        ){
        this.frame = frame;
        this.roll = roll;
        this.remaining = remaining;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        InputControlValues _InputControlValues = (InputControlValues) o;
            boolean result = true;
         if (
             !this.frame.equals("?DNC?")
                && !_InputControlValues.frame.equals("?DNC?"))
                if (! _InputControlValues.frame.equals(this.frame)) result = false;
         if (
             !this.roll.equals("?DNC?")
                && !_InputControlValues.roll.equals("?DNC?"))
                if (! _InputControlValues.roll.equals(this.roll)) result = false;
         if (
             !this.remaining.equals("?DNC?")
                && !_InputControlValues.remaining.equals("?DNC?"))
                if (! _InputControlValues.remaining.equals(this.remaining)) result = false;
             return result;  }
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
    public static class Builder {
        private String frame = "1";
        private String roll = "1";
        private String remaining = "10";
        public Builder setFrame(String frame) {
            this.frame = frame;
            return this;
            }
        public Builder setRoll(String roll) {
            this.roll = roll;
            return this;
            }
        public Builder setRemaining(String remaining) {
            this.remaining = remaining;
            return this;
            }
        public Builder  setCompare() {
            frame = "?DNC?";
            roll = "?DNC?";
            remaining = "?DNC?";
            return this;
            }
        public InputControlValues build(){
             return new InputControlValues(
                 frame
                 ,roll
                 ,remaining
                );   } 
        } 
        @Override
        public String toString() {
            return "InputControlValues {"
             +"frame = " + frame + " "
             +"roll = " + roll + " "
             +"remaining = " + remaining + " "
             + "} " + "\n"; }

    public String toJson() {
        return " {"
         +""+"frame:" + "\"" + frame + "\""
         + ","         +""+"roll:" + "\"" + roll + "\""
         + ","         +""+"remaining:" + "\"" + remaining + "\""
                + "} " ; }

        public static InputControlValues fromJson(String json) {
              InputControlValues instance = new InputControlValues();

              	json = json.replaceAll("\\s", "");
                String[] keyValuePairs = json.replace("{", "").replace("}", "").split(",");

                // Iterate over the key-value pairs
                for (String pair : keyValuePairs) {
                    // Split each pair by the colon
                    String[] entry = pair.split(":");

                    // Remove the quotes from the key and value
                    String key = entry[0].replace("\"", "").trim();
                    String value = entry[1].replace("\"", "").trim();


          // Assign the value to the corresponding field
                    switch (key) {
              case "frame":
                  instance.frame = value;
                  break;
              case "roll":
                  instance.roll = value;
                  break;
              case "remaining":
                  instance.remaining = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<InputControlValues> list) {
                 StringBuilder jsonBuilder = new StringBuilder();
                 jsonBuilder.append("[");

                 for (int i = 0; i < list.size(); i++) {
                     jsonBuilder.append(list.get(i).toJson());
                     if (i < list.size() - 1) {
                         jsonBuilder.append(",");
                     }
                 }

                 jsonBuilder.append("]");
                 return jsonBuilder.toString();
             }

             public static List<InputControlValues> listFromJson(String json) {
                    List<InputControlValues> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(InputControlValues.fromJson(jsonObject));
                         }
                    return list;
                }

    InputControlValuesInternal toInputControlValuesInternal() {
        return new InputControlValuesInternal(
         Integer.valueOf(frame)
        , Integer.valueOf(roll)
        , Integer.valueOf(remaining)
        ); }
    }
